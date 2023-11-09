package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.CollectorTeam;

@Service
public interface ICollectorTeamService {

	void save(CollectorTeam team);

	void update(CollectorTeam team);

	void delete(Long id);

	List<CollectorTeam> getAll();

	CollectorTeam getById(Long id);
}
