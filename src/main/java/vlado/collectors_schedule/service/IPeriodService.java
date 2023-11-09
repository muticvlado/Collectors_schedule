package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.Period;

@Service
public interface IPeriodService {
	
	void save(Period period);
	
	void delete(Long id);
	
	Period getById(Long id);
	
	List<Period> getAll();
}
