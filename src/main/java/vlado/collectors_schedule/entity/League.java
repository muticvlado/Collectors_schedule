package vlado.collectors_schedule.entity;


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
public class League {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			  name = "competition",
			  joinColumns = @JoinColumn(name = "league_id"),
			  inverseJoinColumns = @JoinColumn(name = "hockey_team_id"))
	private List<HockeyTeam> hockey_teams;

	public League() {

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

	public List<HockeyTeam> getHockey_teams() {
		return hockey_teams;
	}

	public void setHockey_teams(List<HockeyTeam> hockey_teams) {
		this.hockey_teams = hockey_teams;
	}
	
	@Override
	public String toString() {
		
		return name + " ";
	}
}
