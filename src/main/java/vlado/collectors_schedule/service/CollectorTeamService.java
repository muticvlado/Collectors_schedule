package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.CollectorTeam;
import vlado.collectors_schedule.repository.CollectorTeamRepo;

@Service
public class CollectorTeamService implements ICollectorTeamService {

	@Autowired
	private CollectorTeamRepo repo;

	@Override
	public void save(CollectorTeam team) {
		if(team != null)
			repo.save(team);
	}

	@Override
	public void update(CollectorTeam team) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {

		repo.deleteById(id);
	}

	@Override
	public List<CollectorTeam> getAll() {

		return repo.findAll();
	}

	@Override
	public CollectorTeam getById(Long id) {

		return repo.findById(id).get();
	}
}
