package vlado.collectors_schedule.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.DataSet;
import vlado.collectors_schedule.service.IDataSetService;

@Controller
public class DataSetController {
	
	@Autowired
	private IDataSetService service;
	
	@GetMapping("/data-sets")
	public String getAllDataSets(Model model) {
		
		model.addAttribute("data_sets", service.getAll());
		return "datasets";
	}
	
	@PostMapping("/save-data-set")
	public String saveLeague(@ModelAttribute DataSet ds) {
		
		service.save(ds);
		return "redirect:/data-sets";		
	}
	
	@GetMapping("/add-data-set-form")
	public String getAddLeagueForm(Model model) {
		
		model.addAttribute("data_set", new DataSet());
		return "dataset";
	}
	
	@GetMapping("/edit-data-set-form")
	public String getEditLeagueForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("data_set", service.getById(id));
		return "dataset";
	}
	
	@GetMapping("/delete-data-set")
	public String deleteLeague(@RequestParam Long id) {
		
		service.delete(id);
		return "redirect:/data-sets";
	}
}
