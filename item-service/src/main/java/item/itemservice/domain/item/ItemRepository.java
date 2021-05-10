package item.itemservice.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

	private static final Map<Long, Item> store = new HashMap<>();
	private static Long seq = 0L;
	
	public Item save(Item item) {
		item.setId(++seq);
		store.put(item.getId(), item);
		return item;
	}
	
	public Item findById(Long id) {
		return store.get(id);
	}
	
	public List<Item> findAll(){
		return new ArrayList<>(store.values());
	}
	
	public void update(Long id, UpdateItem UpdateParam) {
		Item item = findById(id);
		item.setItemName(UpdateParam.getItemName());
		item.setQuantity(UpdateParam.getQuantity());
		item.setPrice(UpdateParam.getPrice());

	}
	
}
