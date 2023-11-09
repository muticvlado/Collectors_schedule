package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.DataSet;
import vlado.collectors_schedule.repository.DataSetRepo;

@Service
public class DataSetService implements IDataSetService {
	
	@Autowired
	private DataSetRepo repo;

	@Override
	public void save(DataSet ds) {
		
		repo.save(ds);		
	}

	@Override
	public void delete(Long id) {
		
		repo.deleteById(id);		
	}

	@Override
	public List<DataSet> getAll() {
		
		return repo.findAll();
	}

	@Override
	public DataSet getById(Long id) {
		
		return repo.findById(id).get();
	}
}
