package vlado.collectors_schedule.controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.Game;
import vlado.collectors_schedule.entity.GameItem;
import vlado.collectors_schedule.helper.Filter;
import vlado.collectors_schedule.service.ICollectorService;
import vlado.collectors_schedule.service.IEventTypeService;
import vlado.collectors_schedule.service.IGameItemService;
import vlado.collectors_schedule.service.IGameService;
import vlado.collectors_schedule.service.IPeriodService;

@Controller
public class GameItemController {
	
	@Autowired
	private IGameItemService itemService;
	@Autowired
	private IGameService gameService;
	@Autowired
	private IEventTypeService etService;
	@Autowired
	private ICollectorService collectorService;
	@Autowired
	private IPeriodService periodService;
	
	@GetMapping("/list-items-of-the-game")
	public String getOneGame(@RequestParam Long id, Model model) {
		
		Game game = gameService.getById(id);
		List<GameItem> items = itemService.getItemsByGameId(id);
		model.addAttribute("game", game);
		model.addAttribute("items", items);
		return "game-items";
	}
	
	@GetMapping("game-item-form")
	public String getItemForm(@RequestParam Long id, Model model) {
		
		Game game = gameService.getById(id);
		GameItem item = new GameItem();
		item.setGame(game);
		//itemService.save(item);
		
		model.addAttribute("item", item);
		model.addAttribute("collectors", collectorService.getAll());
		model.addAttribute("events", etService.getAll());
		model.addAttribute("periods", periodService.getAll());
		
		return "game-item";		
	}
	
	@PostMapping("save-game-item")
	public String saveGameItem(@ModelAttribute GameItem item, Model model) {
		
		Game game = gameService.getById(item.getGame().getId());		
		item.setGame(game);
		if(item.getResponde() != 3 && item.isValid()) {
			model.addAttribute("msg", "Can not validate collection item that is not finished");
			model.addAttribute("back", "edit-game-item-form?id=" + item.getId());
			return "error";
		}
			
		itemService.save(item);
		return "redirect:/list-items-of-the-game?id=" + item.getGame().getId();
	}
	
	@PostMapping("save-game-item-from-all")
	public String saveGameItemFromAll(@ModelAttribute GameItem item) {
		
		Game game = gameService.getById(item.getGame().getId());
		item.setGame(game);
		itemService.save(item);
		return "redirect:/list-of-billing-items";
	}
	
	@GetMapping("delete-game-item")
	public String deleteItemGame(@RequestParam Long id) {
		
		Long idGame = itemService.getById(id).getGame().getId();
		itemService.delete(id);
		
		return "redirect:/list-items-of-the-game?id=" + idGame;
	}
	
	@GetMapping("edit-game-item-form")
	public String getEditItemForm(@RequestParam Long id, Model model) {
		
		GameItem item = itemService.getById(id);
		
		model.addAttribute("item", item);
		model.addAttribute("collectors", collectorService.getAll());
		model.addAttribute("events", etService.getAll());
		model.addAttribute("periods", periodService.getAll());
		
		return "game-item";		
	}
	
	@GetMapping("edit-game-item-form-from-all")
	public String getEditItemFormAll(@RequestParam Long id, Model model) {
		
		GameItem item = itemService.getById(id);
		
		model.addAttribute("item", item);
		model.addAttribute("collectors", collectorService.getAll());
		model.addAttribute("events", etService.getAll());
		model.addAttribute("periods", periodService.getAll());
		
		return "all-item";		
	}
	
	@GetMapping("/list-of-billing-items")
	public String getBillingItems(Model model) {	
		
		Filter filter = new Filter();
		filter.setCollectors(collectorService.getAll());
		filter.setGames(gameService.getAll());
		
		List<GameItem> items = itemService.getAll();	
		
		model.addAttribute("filter", filter);
		model.addAttribute("items", items);
		
		return "billing-items";
	}
	
	@GetMapping("/list-of-billing-items-filter")
	public String getBillingItemsByFilter(@RequestParam Long collector_id, Model model) {
		
		if(collector_id == 0) return "redirect:/list-of-billing-items";
		
		Filter filter = new Filter();
		filter.setCollectors(collectorService.getAll());
		filter.setCollector(collectorService.getById(collector_id));
		filter.setGames(gameService.getAll());
		
		List<GameItem> items = itemService.getItemsByCollectorId(collector_id);
		
		model.addAttribute("filter", filter);		
		model.addAttribute("items", items);
		
		return "billing-items";
	}
}
