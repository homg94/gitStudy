package item.itemservice.domain.item;

public class UpdateItem {
	
	private String itemName;
	private Integer price;
	private int quantity = 0;
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
	public UpdateItem(String itemName, Integer price, int quantity) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	public UpdateItem() {
		super();
	}
	
	
}
