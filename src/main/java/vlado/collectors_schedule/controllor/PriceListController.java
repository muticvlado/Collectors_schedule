package vlado.collectors_schedule.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.collectors_schedule.entity.PriceList;
import vlado.collectors_schedule.service.IPriceListService;

@Controller
public class PriceListController {
	
	@Autowired
	private IPriceListService service;
	
	@GetMapping("/price-lists")
	public String getAllPriceLists(Model model) {
		
		model.addAttribute("priceLists", service.getAll());
		return "price-lists";
	}
	
	@GetMapping("/price-list-form")
	public String getPriceListForm(Model model) {
		
		model.addAttribute("priceList", new PriceList());
		return "price-list";
	}
	
	@PostMapping("save-price-list")
	public String savePriceList(@ModelAttribute PriceList priceList) {
		
		service.save(priceList);
		return "redirect:/price-lists";
	}
	
	@GetMapping("/price-list-edit-form")
	public String getPriceListEditForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("priceList", service.getById(id));
		return "price-list";
	}
	
	@GetMapping("delete-price-list")
	public String deletePriceList(@RequestParam Long id) {
		
		service.delete(id);;
		return "redirect:/price-lists";
	}
}
