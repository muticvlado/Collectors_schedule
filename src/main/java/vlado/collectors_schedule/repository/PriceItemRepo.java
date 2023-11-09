package vlado.collectors_schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vlado.collectors_schedule.entity.PriceItem;

public interface PriceItemRepo extends JpaRepository<PriceItem, Long>{

	@Query(value = "SELECT * FROM collection_db.price_item WHERE collection_db.price_item.price_list_id = ?1 ORDER BY collection_db.price_item.event_type_id", nativeQuery = true)
	public List<PriceItem> getPriceItemsByPriceListId(Long priceListId);
	
	@Query(value = "SELECT price FROM collection_db.price_item WHERE (event_type_id=?1 and price_list_id=?2 and dataset_id=?3)", nativeQuery = true)
	public double getPrice(Long eventId, Long listId, Long dataSetId);
}
