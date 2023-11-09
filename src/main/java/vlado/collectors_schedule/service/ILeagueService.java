package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;
import vlado.collectors_schedule.entity.League;

@Service
public interface ILeagueService {

	void save(League league);

	void delete(Long id);

	List<League> getAll();

	League getById(Long id);
}
