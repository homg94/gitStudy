package item.itemservice.domain.item;

public class Item {

	private Long id;
	private String itemName;
	private Integer price;
	private int quantity = 0;
	public Item() {
		super();
	}
	public Item(String itemName, Integer price, int quantity) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
