package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.Game;

@Service
public interface IGameService {
	
	void save(Game game);
	
	void delete(Long id);
	
	Game getById(Long id);
	
	List<Game> getAll();
}
