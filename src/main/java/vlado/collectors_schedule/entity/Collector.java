package vlado.collectors_schedule.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Collector {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String city;
	@Column
	private String bank_account;
	@Column
	private String phone;
	@Column
	private String discord;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private boolean disabled;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "collector_team_id")
	private CollectorTeam collector_team;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "price_list_id")
	private PriceList priceList;

	public Collector() {

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDiscord() {
		return discord;
	}

	public void setDiscord(String discord) {
		this.discord = discord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CollectorTeam getCollector_team() {
		return collector_team;
	}

	public void setCollector_team(CollectorTeam collector_team) {
		this.collector_team = collector_team;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}
}
