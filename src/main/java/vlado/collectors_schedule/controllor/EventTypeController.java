package vlado.collectors_schedule.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.EventType;
import vlado.collectors_schedule.service.IEventTypeService;

@Controller
public class EventTypeController {
	
	@Autowired
	private IEventTypeService service;
	
	@GetMapping("/event-types")
	public String getAllEventTypes(Model model) {
		
		model.addAttribute("event_types", service.getAll());
		return "eventtypes";
	}
	
	@PostMapping("/save-event-type")
	public String saveLeague(@ModelAttribute EventType et) {
		
		service.save(et);
		return "redirect:/event-types";		
	}
	
	@GetMapping("/add-event-type-form")
	public String getAddLeagueForm(Model model) {
		
		model.addAttribute("event_type", new EventType());
		return "eventtype";
	}
	
	@GetMapping("/edit-event-type-form")
	public String getEditLeagueForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("event_type", service.getById(id));
		return "eventtype";
	}
	
	@GetMapping("/delete-event-type")
	public String deleteLeague(@RequestParam Long id) {
		
		service.delete(id);
		return "redirect:/event-types";
	}
}
