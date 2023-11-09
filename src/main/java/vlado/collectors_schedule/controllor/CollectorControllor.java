package vlado.collectors_schedule.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.Collector;
import vlado.collectors_schedule.service.ICollectorService;
import vlado.collectors_schedule.service.ICollectorTeamService;
import vlado.collectors_schedule.service.IPriceListService;

@Controller
public class CollectorControllor {

	@Autowired
	private ICollectorService service;

	@Autowired
	private ICollectorTeamService team_service;
	
	@Autowired
	private IPriceListService priceListService;

	@GetMapping("/collectors")
	public String getCollectors(Model model) {

		model.addAttribute("collectors", service.getAll());
		return "collectors";
	}

	@GetMapping("/collector-form")
	public String getCollectorForm(Model model) {

		model.addAttribute("collector", new Collector());
		model.addAttribute("priceLists", priceListService.getAll());
		model.addAttribute("teams", team_service.getAll());
		return "collector";
	}

	@PostMapping("/save-collector")
	public String saveCollector(@ModelAttribute Collector collector) {

		service.save(collector);
		return "redirect:/collectors";
	}

	@GetMapping("/collector-edit")
	public String getCollectorEditForm(@RequestParam Long id, Model model) {

		model.addAttribute("collector", service.getById(id));
		model.addAttribute("priceLists", priceListService.getAll());
		model.addAttribute("teams", team_service.getAll());
		return "collector";
	}

	@GetMapping("/collector-delete")
	public String deleteCollector(@RequestParam Long id) {

		service.delete(id);
		return "redirect:/collectors";
	}
	
	@GetMapping("/availability")
	public String getAvailabilityStatus() {
		
		return "availability";
	}
	
}
