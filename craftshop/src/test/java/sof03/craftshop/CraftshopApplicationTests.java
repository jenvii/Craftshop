package sof03.craftshop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sof03.craftshop.web.CategoryController;
import sof03.craftshop.web.HandicraftController;
import sof03.craftshop.web.SellerController;

@SpringBootTest
class CraftshopApplicationTests {
	
	@Autowired
	private HandicraftController handicraftController;
	
	@Autowired
	private CategoryController categoryController;
	
	@Autowired
	private SellerController sellerController;


	@Test
	void contextLoads() {
		assertThat(handicraftController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(sellerController).isNotNull();
	}

}
