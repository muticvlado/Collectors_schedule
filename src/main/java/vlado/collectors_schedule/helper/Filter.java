package vlado.collectors_schedule.helper;

import java.sql.Date;
import java.util.List;

import vlado.collectors_schedule.entity.Collector;
import vlado.collectors_schedule.entity.Game;

public class Filter {
	
	private List<Collector> collectors;
	
	private List<Game> games;
	
	private Date dc_date;
	
	private Collector collector;
	
	public Filter() {	
	}

	public List<Collector> getCollectors() {
		return collectors;
	}

	public void setCollectors(List<Collector> collectors) {
		this.collectors = collectors;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Date getDc_date() {
		return dc_date;
	}

	public void setDc_date(Date dc_date) {
		this.dc_date = dc_date;
	}
	
	public Collector getCollector() {
		return collector;
	}

	public void setCollector(Collector collector) {
		this.collector = collector;
	}

	@Override
	public String toString() {
		String filter = "";
		for(Collector collector : collectors) 
			filter += collector.getName() + "\n";
		return filter;
	}
}
