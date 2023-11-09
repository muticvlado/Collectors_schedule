package vlado.collectors_schedule.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class HockeyTeam {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String short_name;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			  name = "competition",
			  joinColumns = @JoinColumn(name = "hockey_team_id"),
			  inverseJoinColumns = @JoinColumn(name = "league_id"))
	private List<League> leagues;

	public HockeyTeam() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public List<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}
	
	public void addLeague(League league) {
		
		if(leagues == null)
			leagues = new ArrayList<League>();
		
		leagues.add(league);		
		league.getHockey_teams().add(this);
	}
	
	@Override
	public String toString() {
		
		String print = "";
		
		for (League league : leagues) {
			print += league.getName() + " ";			
		}
		
		return name + "/ " + print;
	}
}
