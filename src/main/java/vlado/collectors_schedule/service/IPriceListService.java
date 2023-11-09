package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.PriceList;

@Service
public interface IPriceListService {
	
	void save(PriceList priceList);
	
	void delete(Long id);
	
	PriceList getById(Long id);
	
	List<PriceList> getAll();
}
