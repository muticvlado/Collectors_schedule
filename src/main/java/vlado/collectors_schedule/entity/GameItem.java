package vlado.collectors_schedule.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GameItem {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int period;	// -1 0 1 2 3
	
	@Column
	private boolean valid;
	
	@Column
	private int responde; // 0 1 2 bez odgovora, yes, no
	
	@Column
	private float amount;
	
	@Column
	private double price;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "period_id")
	private Period periodGame;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "game_id")
	private Game game;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "collector_id")
	private Collector collector;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "eventtype_id")
	private EventType eventType;

	public GameItem() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Collector getCollector() {
		return collector;
	}

	public void setCollector(Collector collector) {
		this.collector = collector;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public int getResponde() {
		return responde;
	}

	public void setResponde(int responde) {
		this.responde = responde;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Period getPeriodGame() {
		return periodGame;
	}

	public void setPeriodGame(Period periodGame) {
		this.periodGame = periodGame;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		
		String league = game.getLeague().getName();
		String ds = game.getDataSet().getName();
		String home = game.getHome().getName();
		String away = game.getAway().getName();
		String event = eventType.getName();
		String gameDate = game.getGame_date().toLocalDate().toString();
		String dcDate = game.getDc_date().toLocalDate().toString();
		String dcTime = game.getDc_time();
		String endDate = game.getEnd_date().toLocalDate().toString();
		String endTime = game.getEnd_time();
		
		
		String text = "<p>Poštovani/a " + collector.getName() + ",</p> raspoređeni ste za kolekciju na utakmici:<br><br>";  
		
		text += "<table>"
				+ "<tr>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>League</th>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>Data set</th>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>Home</th>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>Away</th>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>Event type</th>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>Game date</th>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>DC date</th>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>DC time</th>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>END date</th>"
				+ "<th style='background-color: #008CBA; color: white; padding: 5px'>END time</th></tr>";
		
		text += "<tr>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + league + "</td>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + ds + "</td>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + home + "</td>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + away + "</td>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + event + "</td>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + gameDate + "</td>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + dcDate + "</td>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + dcTime + "</td>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + endDate + "</td>"
				+ "<td style='border: solid black 1px; padding: 10px;font-weight: bolder;'>" + endTime + "</td>"
				+ "</tr></table><br>";
		
		text += "Molimo vas da ažurirate vaš odgovor putem linka: "
				+ "<a href=http://localhost:8080/list-items-of-the-game?id=" + game.getId() + ">http://localhost:8080/list-items-of-the-game?id=" + game.getId() + "</a>" + "<br><br>"
				+ "Srdačan pozdrav<br>TIM SRBIJA";
		
		return text;
	}
}
