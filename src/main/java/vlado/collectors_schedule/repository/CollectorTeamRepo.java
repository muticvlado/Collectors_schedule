package vlado.collectors_schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vlado.collectors_schedule.entity.CollectorTeam;

public interface CollectorTeamRepo extends JpaRepository<CollectorTeam, Long>{

}
