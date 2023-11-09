package vlado.collectors_schedule.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.League;
import vlado.collectors_schedule.service.ILeagueService;

@Controller
public class LeagueController {
	
	@Autowired
	private ILeagueService service;
	
	@GetMapping("/leagues")
	public String getAllLeagues(Model model) {
		
		model.addAttribute("leagues", service.getAll());
		return "leagues";
	}
	
	@PostMapping("/save-league")
	public String saveLeague(@ModelAttribute League league) {
		
		service.save(league);
		return "redirect:/leagues";		
	}
	
	@GetMapping("/add-league-form")
	public String getAddLeagueForm(Model model) {
		
		model.addAttribute("league", new League());
		return "league";
	}
	
	@GetMapping("/edit-league-form")
	public String getEditLeagueForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("league", service.getById(id));
		return "league";
	}
	
	@GetMapping("/delete-league")
	public String deleteLeague(@RequestParam Long id) {
		
		service.delete(id);
		return "redirect:/leagues";
	}
}
