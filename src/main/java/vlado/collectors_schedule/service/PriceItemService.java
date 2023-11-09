package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.PriceItem;
import vlado.collectors_schedule.repository.PriceItemRepo;

@Service
public class PriceItemService implements IPriceItemService {

	@Autowired
	private PriceItemRepo repo;

	@Override
	public void save(PriceItem priceItem) {
		
		if(priceItem != null)
			repo.save(priceItem);		
	}

	@Override
	public void delete(Long id) {
		
		repo.deleteById(id);
	}

	@Override
	public PriceItem getById(Long id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<PriceItem> getAll() {
		
		return repo.findAll();
	}

	@Override
	public List<PriceItem> getPriceItemsByPriceListId(Long priceListId) {
		
		return repo.getPriceItemsByPriceListId(priceListId);
	}
	
	@Override
	public Double getPrace(Long eventId, Long listId, Long dataSetId) {
		
		Double price = repo.getPrice(eventId, listId, dataSetId);
		price = price != null ? price : 0;
		
		return price;
	}
}
