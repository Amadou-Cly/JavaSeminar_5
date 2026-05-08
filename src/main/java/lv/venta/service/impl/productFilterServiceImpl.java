package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IproductFilterService;

@Service
public class productFilterServiceImpl implements IproductFilterService{
	
	@Autowired
	private IProductRepo productRepo;

	@Override
	public ArrayList<Product> filterByCategory(Category category) throws Exception {
		if(category == null ) {
			throw new Exception("Wrong input param");
		}
		ArrayList<Product> result = productRepo.findByCategory(category);
		
		if(result.isEmpty()) {
			throw new Exception ("There are no product under Category "+ category);
		}else {
	
		return result;
		}
	}

	@Override
	public ArrayList<Product> filterByPrice(float priceLevel) throws Exception {
		if(priceLevel < 0 || priceLevel > 100) {
			throw new Exception ("The price must be greater than 0 or less than 100");
		}
		ArrayList<Product> result = productRepo.findByPriceLessThan(priceLevel);
		if(result.isEmpty()) {
			throw new Exception ("There is no Product which price is less than "+ priceLevel);
		}
		else {
		return result;
		}
	}

	@Override
	public ArrayList<Product> filterByKeyword(String keyword) throws Exception {
		if (keyword == null || keyword.isEmpty()) {
			throw new Exception ("Keyword can not be null or empty");
		}
		ArrayList<Product> result = productRepo.findByTitleContainingOrDescriptionContaining(keyword, keyword);
		if (result.isEmpty()) {
			throw new Exception("There are no product which title or description consist of "+ keyword);
		}else
		
			return result;
	}

	@Override
	public float calculateAveragePrice() throws Exception {
		
		if(productRepo.count() == 0) {
			throw new Exception("No products in DB and it is not possible to calculate avg price");
		}
		
		float result = productRepo.myCalculateAvgPrice();
		return result;
	}

}