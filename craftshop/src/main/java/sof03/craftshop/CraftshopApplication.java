package sof03.craftshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sof03.craftshop.domain.HandicraftRepository;
import sof03.craftshop.domain.Seller;
import sof03.craftshop.domain.SellerRepository;
import sof03.craftshop.domain.Handicraft;
import sof03.craftshop.domain.Category;
import sof03.craftshop.domain.CategoryRepository;

@SpringBootApplication
public class CraftshopApplication {
	private static final Logger log = LoggerFactory.getLogger(CraftshopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CraftshopApplication.class, args);
	}

	@Bean
	public CommandLineRunner handicrafts(HandicraftRepository handicraftRepository,
			CategoryRepository categoryRepository, SellerRepository sellerRepository) {
		return (args) -> {
			log.info("save categories");
	        Category category1 = new Category("Crochet");
	        categoryRepository.save(category1);
	        Category category2 = new Category("Knit");
	        categoryRepository.save(category2);
	        log.info("fetch all categories");
	        for (Category category : categoryRepository.findAll()) {
	            log.info(category.toString());
	        }
	        
	        log.info("save sellers");
	        Seller seller1 = new Seller("Pirkko", "040 1234567", "pirkko@pirkkonen.fi");
	        sellerRepository.save(seller1);
	        Seller seller2 = new Seller("Jarkko", "050 9876543", "jarkko@jarkkonen.fi");
	        sellerRepository.save(seller2);
	        log.info("fetch all sellers");
	        for (Seller seller : sellerRepository.findAll()) {
	        	log.info(seller.toString());
	        }
	        	
			
			log.info("save handicrafts");
			Handicraft handicraft1 = new Handicraft("Socks", "100% wool socks. Comfy for winter!", category2, 10L, seller1);
			handicraftRepository.save(handicraft1);
			Handicraft handicraft2 = new Handicraft("Crochet top", "80% wool cool top for everyday wear", category1, 30L, seller2);
			handicraftRepository.save(handicraft2);
			for (Handicraft handicraft : handicraftRepository.findAll()) {
				log.info(handicraft.toString());
			}
			
		};

	}
}
