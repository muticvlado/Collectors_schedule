 package vlado.collectors_schedule.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@javax.persistence.Entity
public class CollectorTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;

	@OneToMany(mappedBy = "collector_team",
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Collector> collectors;

	public CollectorTeam() {

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

	public List<Collector> getCollectors() {
		return collectors;
	}

	public void setCollectors(List<Collector> collectors) {
		this.collectors = collectors;
	}
}
