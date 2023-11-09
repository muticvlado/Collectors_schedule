package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.GameItem;

@Service
public interface IGameItemService {
	
	void save(GameItem item);
	
	void delete(Long id);
	
	GameItem getById(Long id);
	
	List<GameItem> getAll();
	
	List<GameItem> getItemsByGameId(Long gameId);
	
	List<GameItem> getItemsByCollectorId(Long collectorId);
}
