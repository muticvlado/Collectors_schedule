package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.EventType;
import vlado.collectors_schedule.repository.EventTypeRepo;

@Service
public class EventTypeService implements IEventTypeService {
	
	@Autowired
	private EventTypeRepo repo;

	@Override
	public void save(EventType et) {
		
		repo.save(et);		
	}

	@Override
	public void delete(Long id) {
		
		repo.deleteById(id);		
	}

	@Override
	public List<EventType> getAll() {
		
		return repo.findAll();
	}

	@Override
	public EventType getById(Long id) {
		
		return repo.findById(id).get();
	}
}
