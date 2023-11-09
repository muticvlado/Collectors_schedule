package vlado.collectors_schedule.controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.PriceItem;
import vlado.collectors_schedule.entity.PriceList;
import vlado.collectors_schedule.service.IDataSetService;
import vlado.collectors_schedule.service.IEventTypeService;
import vlado.collectors_schedule.service.IPriceItemService;
import vlado.collectors_schedule.service.IPriceListService;

@Controller
public class PriceItemController {

	@Autowired
	private IPriceItemService priceItemService;
	
	@Autowired
	private IPriceListService priceListService;
	
	@Autowired
	private IEventTypeService eventService;
	
	@Autowired
	private IDataSetService dataSetService;
	
	@GetMapping("/list-items-of-the-price-list")
	public String getOneGame(@RequestParam Long id, Model model) {
		
		PriceList priceList = priceListService.getById(id);
		List<PriceItem> items = priceItemService.getPriceItemsByPriceListId(id);
		model.addAttribute("priceList", priceList);
		model.addAttribute("items", items);
		return "price-list-items";
	}
	
	@GetMapping("/price-list-item-form")
	public String getPriceListItemForm(@RequestParam Long id, Model model) {
		
		PriceList priceList = priceListService.getById(id);
		PriceItem item = new PriceItem();
		item.setPriceList(priceList);

		
		model.addAttribute("item", item);
		model.addAttribute("events", eventService.getAll());
		model.addAttribute("datasets", dataSetService.getAll());
		
		return "price-list-item";		
	}
	
	@PostMapping("/save-price-list-item")
	public String savePriceItem(@ModelAttribute PriceItem priceItem) {
		
		Long priceListId = priceItem.getPriceList().getId();
		PriceList priceList = priceListService.getById(priceListId);
		priceItem.setPriceList(priceList);
		priceItemService.save(priceItem);

		return "redirect:/list-items-of-the-price-list?id=" + priceListId;
	}
	
	@GetMapping("/edit-price-item-form")
	public String getPriceListItemEditForm(@RequestParam Long id, Model model) {
		
		PriceItem item = priceItemService.getById(id);
		
		model.addAttribute("item", item);
		model.addAttribute("events", eventService.getAll());
		model.addAttribute("datasets", dataSetService.getAll());
		
		return "price-list-item";		
	}
}
