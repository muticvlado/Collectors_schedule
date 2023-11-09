package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.League;
import vlado.collectors_schedule.repository.LeagueRepo;

@Service
public class LeagueService implements ILeagueService {
	
	@Autowired
	private LeagueRepo repo;

	@Override
	public void save(League league) {
		
		repo.save(league);
	}

	@Override
	public void delete(Long id) {
		
		repo.deleteById(id);		
	}

	@Override
	public List<League> getAll() {
	
		return repo.findAll();
	}

	@Override
	public League getById(Long id) {
		
		return repo.findById(id).get();
	}
}
