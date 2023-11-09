package vlado.collectors_schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vlado.collectors_schedule.entity.Period;

public interface PeriodRepo extends JpaRepository<Period, Long> {

}
