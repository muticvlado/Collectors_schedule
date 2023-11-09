package vlado.collectors_schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vlado.collectors_schedule.entity.GameItem;

public interface GameItemRepo extends JpaRepository<GameItem, Long> {
	
	@Query(value = "SELECT * FROM GAME_ITEM WHERE GAME_ID = ?1 ORDER BY PERIOD, EVENTTYPE_ID", nativeQuery = true)
	public List<GameItem> getGameItemsByGameId(Long gameId);
	
	@Query(value = "SELECT * FROM GAME_ITEM WHERE COLLECTOR_ID = ?1 ORDER BY PERIOD, EVENTTYPE_ID", nativeQuery = true)
	public List<GameItem> getGameItemsByCollectorId(Long collectorId);
}
