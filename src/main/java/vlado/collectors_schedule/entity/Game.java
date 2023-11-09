package vlado.collectors_schedule.entity;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date game_date;
	@Column
	private Date dc_date;
	@Column
	private String dc_time;
	@Column
	private Date end_date;
	@Column
	private String end_time;
	@Column
	private String note;
	@Column
	private Boolean complete;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "league_id")
	private League league;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "dataset_id")
	private DataSet dataSet;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "hockeyteam_home_id")
	private HockeyTeam home;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "hockeyteam_away_id")	
	private HockeyTeam away;

	public Game() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGame_date() {
		return game_date;
	}

	public void setGame_date(Date game_date) {
		this.game_date = game_date;
	}

	public Date getDc_date() {
		return dc_date;
	}

	public void setDc_date(Date dc_date) {
		this.dc_date = dc_date;
	}

	public String getDc_time() {
		
		return dc_time;
	}

	public void setDc_time(String dc_time) {
		this.dc_time = dc_time;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public DataSet getDataSet() {
		return dataSet;
	}

	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	public HockeyTeam getHome() {
		return home;
	}

	public void setHome(HockeyTeam home) {
		this.home = home;
	}

	public HockeyTeam getAway() {
		return away;
	}

	public void setAway(HockeyTeam away) {
		this.away = away;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}	

	public Boolean isComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	@Override
	public String toString() {
		
		return league.getName() + " " + dataSet.getName() + " " + dc_date + " " + dc_time + " " + home.getName() + " " + away.getName();
	}
}
