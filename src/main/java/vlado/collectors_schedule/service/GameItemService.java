package vlado.collectors_schedule.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.GameItem;
import vlado.collectors_schedule.repository.GameItemRepo;

@Service
public class GameItemService implements IGameItemService {
	
	@Autowired
	private GameItemRepo repo;
	
	@Autowired
	private IPriceItemService priceItemService;
	
	@Autowired
	private InfoEmailService emailService;

	@Override
	public void save(GameItem item) {
		
		float amount = item.getPeriodGame().getAmount();
		item.setAmount(amount);
		
		long dataSetId = item.getGame().getDataSet().getId();
		long priceListId = item.getCollector().getPriceList().getId();
		long eventTypeId = item.getEventType().getId();
		
		Double price = priceItemService.getPrace(eventTypeId, priceListId, dataSetId);
		if(price != null)
			item.setPrice(price);
		else
			item.setPrice(0);
		
		try {
			emailService.sendHtmlEmail(item);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		repo.save(item);
	}

	@Override
	public void delete(Long id) {
		
		repo.deleteById(id);
	}

	@Override
	public GameItem getById(Long id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<GameItem> getAll() {
		
		return repo.findAll();
	}

	@Override
	public List<GameItem> getItemsByGameId(Long gameId) {
		
		return repo.getGameItemsByGameId(gameId);
	}

	@Override
	public List<GameItem> getItemsByCollectorId(Long collectorId) {
		
		return repo.getGameItemsByCollectorId(collectorId);
	}
}
