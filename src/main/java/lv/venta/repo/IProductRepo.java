package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Category;
import lv.venta.model.Product;

public interface IProductRepo extends CrudRepository<Product,	 Integer> {

	boolean existsByTitleAndCategoryAndPriceAndQuantityAndDescription(String title, Category category, float price,
			int quantity, String description);
	//Only abs functions will be there

	ArrayList<Product> findByCategory(java.util.Locale.Category category);

	ArrayList<Product> findByPriceLessThan(float priceLevel);

	ArrayList<Product> findByTitleContainingOrDescriptionContaining(String keyword, String keyword2);
	
	@Query(nativeQuery = true , value = "SELECT AVG(PRICE) FROM PRODUCT_TABLE;")
	float myCalculateAvgPrice();
	

}
