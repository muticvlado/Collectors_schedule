package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.Collector;
import vlado.collectors_schedule.repository.CollectorRepo;

@Service
public class CollectorService implements ICollectorService {

	@Autowired
	private CollectorRepo repo;

	@Override
	public void save(Collector collector) {

		if(collector != null)
			repo.save(collector);
	}

	@Override
	public void update(Collector collector) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {

		repo.deleteById(id);
	}

	@Override
	public List<Collector> getAll() {

		return repo.findAll();
	}

	@Override
	public Collector getById(Long id) {

		return repo.findById(id).get();
	}
}
