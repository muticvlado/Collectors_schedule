package vlado.collectors_schedule.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.Period;
import vlado.collectors_schedule.service.IPeriodService;

@Controller
public class PeriodController {
	
	@Autowired
	private IPeriodService service;
	
	
	@GetMapping("/periods")
	public String getAllPeriods(Model model) {
		
		model.addAttribute("periods", service.getAll());
		return "periods";
	}
	
	@GetMapping("/period-form")
	public String getPeriodForm(Model model) {
		
		model.addAttribute("period", new Period());
		return "period";		
	}
	
	@PostMapping("save-period")
	public String savePeriod(@ModelAttribute Period period) {
		
		service.save(period);
		return "redirect:/periods";
	}
	
	@GetMapping("/period-delete")
	public String deletePeriod(@RequestParam Long id) {
		
		service.delete(id);
		return "redirect:/periods";
	}
	
	@GetMapping("/period-edit")
	public String getPeriodEditForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("period", service.getById(id));
		return "period";
	}

}
