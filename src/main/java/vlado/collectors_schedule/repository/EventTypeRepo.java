package vlado.collectors_schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vlado.collectors_schedule.entity.EventType;

public interface EventTypeRepo extends JpaRepository<EventType, Long>{

}
