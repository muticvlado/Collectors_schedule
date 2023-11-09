package vlado.collectors_schedule.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.CollectorTeam;
import vlado.collectors_schedule.service.ICollectorTeamService;

@Controller
public class CollectorTeamControllor {

	@Autowired
	private ICollectorTeamService service;

	@GetMapping("/collector-teams")
	public String getCollectorTeams(Model model) {

		model.addAttribute("teams", service.getAll());
		return "collector-teams";
	}

	@GetMapping("/collector-team-form")
	public String getCollectorTeamsForm(Model model) {

		model.addAttribute("collectorTeam", new CollectorTeam());
		return "collector-team";
	}

	@PostMapping("/save-collector-team")
	public String saveCollectorTeam(@ModelAttribute CollectorTeam team) {

		service.save(team);
		return "redirect:/collector-teams";
	}

	@GetMapping("/collector-team-edit")
	public String getCollectorTeamEditForm(@RequestParam Long id, Model model) {

		model.addAttribute("collectorTeam", service.getById(id));
		return "collector-team";
	}

	@GetMapping("/collector-team-delete")
	public String deleteCollectorTeam(@RequestParam Long id) {

		service.delete(id);
		return "redirect:/collector-teams";
	}
}
