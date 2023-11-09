package vlado.collectors_schedule.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.HockeyTeam;
import vlado.collectors_schedule.service.IHockeyTeamService;
import vlado.collectors_schedule.service.ILeagueService;

@Controller
public class HockeyTeamController {
	
	@Autowired
	private IHockeyTeamService service;
	
	@Autowired
	private ILeagueService leagueService;
	
	@GetMapping("/hockey-teams")
	public String getAllHockeyTeams(Model model) {
		
		model.addAttribute("hockey_teams", service.getAll());
		return "hockey-teams";
	}
	
	@PostMapping("/save-hockey-team")
	public String saveLeague(@ModelAttribute HockeyTeam hockey_team) {
		
		System.out.println(hockey_team);
		service.save(hockey_team);
		return "redirect:/hockey-teams";		
	}
	
	@GetMapping("/add-hockey-team-form")
	public String getAddHockeyTeamForm(Model model) {
		
		model.addAttribute("hockey_team", new HockeyTeam());
		model.addAttribute("all_leagues", leagueService.getAll());
		return "hockey-team";
	}
	
	@GetMapping("/edit-hockey-team-form")
	public String getEditHockeyTeamForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("hockey_team", service.getById(id));
		model.addAttribute("all_leagues", leagueService.getAll());
		return "hockey-team";
	}
	
	@GetMapping("/delete-hockey-team")
	public String deleteHockeyTeam(@RequestParam Long id) {
		
		service.delete(id);
		return "redirect:/hockey-teams";
	}
}
