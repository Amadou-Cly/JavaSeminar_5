package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Category;
import lv.venta.model.Product;

public interface IProductCRUDService {
	//Only abstract functions
	
	//Create
	public abstract void createProduct(String title, Category category, float price, int quatity, 
			String description) throws Exception;
	
	//Retrieve
	public abstract ArrayList<Product> retreiveAllPoducts()throws Exception;

	
	//R- retreive by Id
	public abstract Product retreiveProductById(int id )throws Exception;
	
	
	//U-update
	public abstract void updateProductById(int id, String title, Category category, float price, int quatity, 
			String description) throws Exception;
	
	//Delete by Id
	public abstract void deleteProductById(int id) throws Exception;
	
	
}
