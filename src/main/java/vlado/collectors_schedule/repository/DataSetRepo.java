package vlado.collectors_schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vlado.collectors_schedule.entity.DataSet;

public interface DataSetRepo extends JpaRepository<DataSet, Long>{

}
