package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.EventType;

@Service
public interface IEventTypeService {
	
	public void save(EventType ds);
	
	public void delete(Long id);
	
	public List<EventType> getAll();
	
	public EventType getById(Long id);
}
