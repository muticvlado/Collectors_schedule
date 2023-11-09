package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.Game;
import vlado.collectors_schedule.repository.GameRepo;

@Service
public class GameService implements IGameService {
	
	@Autowired
	private GameRepo repo;

	@Override
	public void save(Game game) {
		
		repo.save(game);		
	}

	@Override
	public void delete(Long id) {
		
		repo.deleteById(id);		
	}

	@Override
	public Game getById(Long id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<Game> getAll() {
		
		return repo.findAll();
	}
}
