package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.HockeyTeam;

@Service
public interface IHockeyTeamService {

	void save(HockeyTeam team);

	void delete(Long id);

	List<HockeyTeam> getAll();

	HockeyTeam getById(Long id);
}
