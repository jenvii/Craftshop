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
import sof03.craftshop.domain.User;
import sof03.craftshop.domain.UserRepository;

@SpringBootApplication
public class CraftshopApplication {
	private static final Logger log = LoggerFactory.getLogger(CraftshopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CraftshopApplication.class, args);
	}

	@Bean
	public CommandLineRunner handicrafts(HandicraftRepository handicraftRepository,
			CategoryRepository categoryRepository, SellerRepository sellerRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save categories");
	        Category category1 = new Category("Crochet");
	        categoryRepository.save(category1);
	        Category category2 = new Category("Knit");
	        categoryRepository.save(category2);
	        Category category3 = new Category("Oil painting");
	        categoryRepository.save(category3);
	        Category category4 = new Category("Woodworking");
	        categoryRepository.save(category4);
	        log.info("fetch all categories");
	        for (Category category : categoryRepository.findAll()) {
	            log.info(category.toString());
	        }
	        
	        log.info("save sellers");
	        Seller seller1 = new Seller("Pirkko", "040 1234567", "pirkko@pirkkonen.fi");
	        sellerRepository.save(seller1);
	        Seller seller2 = new Seller("Jarkko", "050 9876543", "jarkko@jarkkonen.com");
	        sellerRepository.save(seller2);
	        Seller seller3 = new Seller("Riina", "045 5678912", "riina@riinala.com");
	        sellerRepository.save(seller3);
	        Seller seller4 = new Seller("Niina", "040 7654329", "niina@niinanen.fi");
	        sellerRepository.save(seller4);
	        log.info("fetch all sellers");
	        for (Seller seller : sellerRepository.findAll()) {
	        	log.info(seller.toString());
	        }
	        	
			
			log.info("save handicrafts");
			Handicraft handicraft1 = new Handicraft("Socks", "100% wool socks. Comfy for winter!", category2, 10L, seller1);
			handicraftRepository.save(handicraft1);
			Handicraft handicraft2 = new Handicraft("Crochet top", "80% wool cool top for everyday wear", category1, 30L, seller3);
			handicraftRepository.save(handicraft2);
			Handicraft handicraft3 = new Handicraft("Horse statue", "A wooden horse sculpture to spruce up your home", category4, 50L, seller2);
			handicraftRepository.save(handicraft3);
			Handicraft handicraft4 = new Handicraft("Colorful painting", "An abstract painting for an abstract person", category3, 40L, seller4);
			handicraftRepository.save(handicraft4);
			Handicraft handicraft5 = new Handicraft("Pink Sweater", "The warmest (and cutest) sweater for the coldest season", category2, 30L, seller3);
			handicraftRepository.save(handicraft5);
			for (Handicraft handicraft : handicraftRepository.findAll()) {
				log.info(handicraft.toString());
			}
			
			log.info("save users");
			User user1 = new User("user", "$2a$10$x/4Nyl/E57/6WgV6CgjiceofeASxGIQ/vn5HV5rdIxj2Jh9c6.5hi", "USER" );
			userRepository.save(user1);
			User user2 = new User("seller", "$2a$10$zeqWg1XVZJkVKCfiERx8X.Dc66JuGpE4BVUZpyvSurEWY4/lTYk06", "SELLER");
			userRepository.save(user2);
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			
		};

	}
}
