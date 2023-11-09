package vlado.collectors_schedule.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PriceList {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	
	@OneToMany(mappedBy = "priceList")
	private List<PriceItem> priceItems;
	
	public PriceList() {
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

	public List<PriceItem> getPriceItems() {
		if(priceItems == null)
			priceItems = new ArrayList<PriceItem>();
		return priceItems;
	}

	public void setPriceItems(List<PriceItem> priceItems) {
		this.priceItems = priceItems;
	}

}
