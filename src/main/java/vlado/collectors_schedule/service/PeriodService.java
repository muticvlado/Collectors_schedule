package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.Period;
import vlado.collectors_schedule.repository.PeriodRepo;

@Service
public class PeriodService implements IPeriodService {
	
	@Autowired
	private PeriodRepo repo;

	@Override
	public void save(Period period) {
		
		repo.save(period);		
	}

	@Override
	public void delete(Long id) {
		
		if(id != null) 
			repo.deleteById(id);		
	}

	@Override
	public Period getById(Long id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<Period> getAll() {
	
		return repo.findAll();
	}

}
