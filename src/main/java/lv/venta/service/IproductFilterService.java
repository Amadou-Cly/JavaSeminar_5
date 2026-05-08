package lv.venta.service;

import java.util.ArrayList;
import java.util.Locale.Category;

import lv.venta.model.Product;

public interface IproductFilterService {
	public abstract ArrayList<Product> filterByCategory(Category category)throws Exception;
	public abstract ArrayList<Product> filterByPrice(float priceLevel ) throws Exception;
	public abstract ArrayList<Product> filterByKeyword(String keyword ) throws Exception;
	public abstract float calculateAveragePrice() throws Exception;
}
