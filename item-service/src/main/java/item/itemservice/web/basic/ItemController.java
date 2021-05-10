package item.itemservice.web.basic;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import item.itemservice.domain.item.Item;
import item.itemservice.domain.item.ItemRepository;
import item.itemservice.domain.item.UpdateItem;

@Controller
@RequestMapping("/basic/items")
public class ItemController {
	
	private ItemRepository store;
	
	@Autowired
	public ItemController(ItemRepository store) {
		this.store=store;
	}
	
	@GetMapping
	public String items(Model model) {
		List<Item> items = store.findAll();
		model.addAttribute("items",items);
		return "basic/items";
	}
	
	@GetMapping("/{itemId}")
	public String itemDetail(@PathVariable Long itemId, Model model) {
		System.out.println(itemId);
		Item item = store.findById(itemId);
		model.addAttribute(item);
		return "basic/item";
	}
	
	
	@PostConstruct
	public void init() {
		store.save(new Item("itemA", 20000, 10));
		store.save(new Item("itemB", 10000, 10));
		store.save(new Item("itemC", 30000, 10));
		store.save(new Item("itemD", 10000, 20));
		store.save(new Item("itemE", 15000, 5));

	}
	
	@GetMapping("/{itemId}/edit")
	public String edit(@PathVariable long itemId, Model model) {
		Item item = store.findById(itemId);
		model.addAttribute("item",item);
		return "basic/editForm";
	}
	
	@PostMapping("/{itemId}/edit")
	public String update(@PathVariable long itemId, @ModelAttribute("item") UpdateItem item) {
		Item previous = store.findById(itemId);
		previous.setItemName(item.getItemName());
		previous.setPrice(item.getPrice());;
		previous.setQuantity(item.getQuantity());
		
		return "redirect:/basic/items";
		
	}
	
}
