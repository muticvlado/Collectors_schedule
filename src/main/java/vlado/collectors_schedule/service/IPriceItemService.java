package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.PriceItem;

@Service
public interface IPriceItemService {

	void save(PriceItem priceItem);
	
	void delete(Long id);
	
	PriceItem getById(Long id);
	
	List<PriceItem> getAll();
	
	List<PriceItem> getPriceItemsByPriceListId(Long priceListId);
	
	Double getPrace(Long eventId, Long listId, Long dataSetId);
}
