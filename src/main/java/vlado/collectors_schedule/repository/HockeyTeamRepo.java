package vlado.collectors_schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vlado.collectors_schedule.entity.HockeyTeam;

public interface HockeyTeamRepo extends JpaRepository<HockeyTeam, Long>{

}
