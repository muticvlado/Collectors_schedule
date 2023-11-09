package vlado.collectors_schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.DataSet;

@Service
public interface IDataSetService {
	
	public void save(DataSet ds);
	
	public void delete(Long id);
	
	public List<DataSet> getAll();
	
	public DataSet getById(Long id);
}
