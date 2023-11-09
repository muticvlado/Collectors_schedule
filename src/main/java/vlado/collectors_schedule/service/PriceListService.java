package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.PriceList;
import vlado.collectors_schedule.repository.PriceListRepo;

@Service
public class PriceListService implements IPriceListService {

	@Autowired
	private PriceListRepo repo;
	
	@Override
	public void save(PriceList priceList) {
		
		repo.save(priceList);		
	}

	@Override
	public void delete(Long id) {
		
		if(id != null)
			repo.deleteById(id);		
	}

	@Override
	public PriceList getById(Long id) {
		
			return repo.findById(id).get();
	}

	@Override
	public List<PriceList> getAll() {
		
		return repo.findAll();
	}
}
