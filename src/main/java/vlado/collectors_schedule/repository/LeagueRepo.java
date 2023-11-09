package vlado.collectors_schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vlado.collectors_schedule.entity.League;

public interface LeagueRepo extends JpaRepository<League, Long> {

}
