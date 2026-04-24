package lv.venta.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "ProductTable")
public class Product {
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	@Column(name = "Title")
	private String title;
	
	@NotNull
	@Column(name = "Category")
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Min(0)
	@Max(500)
	@Column(name = "Price")
	private float price;
	
	@Min(0)
	@Max(100)
	@Column(name = "Quantity")
	private int quantity;
	
	@NotNull
	@NotEmpty
	@Column(name = "Description")
	private String description;
	
	// Id should be unique from Data Base
	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//Getters and setters
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
	
	public Product( String title, Category category, float price, int quatity, String description) {
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
