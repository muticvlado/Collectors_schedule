package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.Collector;

@Service
public interface ICollectorService {

	void save(Collector collector);

	void update(Collector collector);

	void delete(Long id);

	List<Collector> getAll();

	Collector getById(Long id);
}
