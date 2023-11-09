package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.HockeyTeam;
import vlado.collectors_schedule.repository.HockeyTeamRepo;

@Service
public class HockeyTeamService implements IHockeyTeamService {
	
	@Autowired
	private HockeyTeamRepo repo;

	@Override
	public void save(HockeyTeam team) {
		
		repo.save(team);		
	}

	@Override
	public void delete(Long id) {
		
		repo.deleteById(id);		
	}

	@Override
	public List<HockeyTeam> getAll() {
		
		return repo.findAll();
	}

	@Override
	public HockeyTeam getById(Long id) {
		
		return repo.findById(id).get();
	}
}
