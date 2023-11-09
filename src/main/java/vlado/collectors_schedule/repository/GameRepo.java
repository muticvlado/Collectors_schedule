package vlado.collectors_schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vlado.collectors_schedule.entity.Game;

public interface GameRepo extends JpaRepository<Game, Long> {
	
}
