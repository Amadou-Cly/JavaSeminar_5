package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Category;
import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class Seminar5Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar5Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testDataBase(IProductRepo prodRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product productData = new Product( "Apple",Category.computer , 250, 1, "Macbook");
				Product productData1 = new Product( "Apple",Category.fruits , 0.25f, 1, "green");
				Product productDat2 = new Product( "Orange",Category.fruits , 0.85f, 5, "Ogange");
				
				prodRepo.save(productData);
				prodRepo.save(productData1);
				prodRepo.save(productDat2);
				
			}
		};
	} 

}
