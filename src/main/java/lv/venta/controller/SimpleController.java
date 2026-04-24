package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Category;
import lv.venta.model.Product;

@Controller
public class SimpleController {

	@GetMapping("/simple")//localhost:8080/simple
	public String getControllerSimple() {
		System.out.println("The simple controller is running");
		return "simple-page";//wiil show simple-page.html file
	}
	
	@GetMapping("/data")//localhost:8080/simple
	public String getControllerData(Model model) {
		System.out.println("The data is running");
		Random random = new Random();
		String myData = "@ Amadou, " + random.nextInt(2020, 2026);
		
		model.addAttribute("box", myData);
		return "data-page";//data-page.html file
	}
	
	@GetMapping("/product")//localhost:8080/product
	public String getControllerProduct(Model model) {
		System.out.println("Product is running");
		
		Product productData = new Product(2, "apple",Category.computer , 250, 1, "Macbook");
		
		model.addAttribute("box", productData);
		return "product-page";
	}
	
	@GetMapping("/all-products")//localhost:8080/all-products
	public String getControllerallproduct(Model model) {
		System.out.println("All Product is running");
		
		Product productData1 = new Product(1, "apple",Category.fruits , 0.25f, 1, "fruits");
		Product productData = new Product(3, "orange",Category.fruits , 0.85f, 5, "Ogange-fruits");
		
		ArrayList<Product>allProducts = new ArrayList<Product>();
		allProducts.add(productData1);
		allProducts.add(productData);
		
		model.addAttribute("box", allProducts);
		return "all-products-page";
		
}
}
