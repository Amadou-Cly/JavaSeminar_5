package lv.venta.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Product {
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	private String title;
	
	@NotNull
	private Category category;
	
	@Min(0)
	@Max(100)
	private float price;
	
	@Min(0)
	@Max(100)
	private int quantity;
	
	@NotNull
	@NotEmpty
	private String description;
	
	// Id should be unique from Data Base
	private int id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

// Constructors
	public Product() {}
	
	public Product(int id, String title, Category category, float price, int quatity, String description) {
		setId(id);
		setTitle(title);
		setCategory(category);
		setDescription(description);
		setPrice(price);
		setQuantity(quatity);
	}
//toString
	public String toString() {
		String result = id + ": "+ title + ", " + price + ", " + category + ", "
				+ description + ", "+ quantity;
		return result;
	}
}
