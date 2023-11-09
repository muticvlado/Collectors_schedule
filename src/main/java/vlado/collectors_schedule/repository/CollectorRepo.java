package vlado.collectors_schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vlado.collectors_schedule.entity.Collector;

public interface CollectorRepo extends JpaRepository<Collector, Long>{

}
