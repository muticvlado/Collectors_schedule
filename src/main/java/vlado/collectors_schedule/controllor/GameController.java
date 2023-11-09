package vlado.collectors_schedule.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.Game;
import vlado.collectors_schedule.service.IDataSetService;
import vlado.collectors_schedule.service.IGameService;
import vlado.collectors_schedule.service.IHockeyTeamService;
import vlado.collectors_schedule.service.ILeagueService;

@Controller
public class GameController {
	
	@Autowired
	private IGameService service;
	@Autowired
	private ILeagueService leagueService;
	@Autowired
	private IDataSetService dataSetService;
	@Autowired
	private IHockeyTeamService hcTeamService;
	
	@GetMapping("/games")
	public String getAllGames(Model model) {
		
		model.addAttribute("games", service.getAll());
		return "games";
	}
	
	@GetMapping("/game-form")
	public String getGameForm(Model model) {
		
		model.addAttribute("game", new Game());	
		model.addAttribute("leagues", leagueService.getAll());
		model.addAttribute("data_sets", dataSetService.getAll());
		model.addAttribute("hcteams", hcTeamService.getAll());
		return "game";
	}
	
	@PostMapping("save-game")
	public String saveGame(@ModelAttribute Game game) {
		
		service.save(game);
		return "redirect:/games";
	}
	
	@GetMapping("game-delete")
	public String deleteGame(@RequestParam Long id) {
		
		service.delete(id);		
		return "redirect:/games";
	}
	
	@GetMapping("/game-edit")
	public String getGameForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("game", service.getById(id));	
		model.addAttribute("leagues", leagueService.getAll());
		model.addAttribute("data_sets", dataSetService.getAll());
		model.addAttribute("hcteams", hcTeamService.getAll());
		return "game";
	}
}
