package sof03.craftshop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sof03.craftshop.web.CategoryController;
import sof03.craftshop.web.CategoryRestController;
import sof03.craftshop.web.HandicraftController;
import sof03.craftshop.web.HandicraftRestController;
import sof03.craftshop.web.SellerController;
import sof03.craftshop.web.SellerRestController;

@SpringBootTest
class CraftshopApplicationTests {

	@Autowired
	private HandicraftController handicraftController;
	
	@Autowired
	private HandicraftRestController handicraftRestController;

	@Autowired
	private CategoryController categoryController;
	
	@Autowired
	private CategoryRestController categoryRestController;

	@Autowired
	private SellerController sellerController;
	
	@Autowired
	private SellerRestController sellerRestController;

	// Smoke-testi kaikille controllereille
	@Test
	void contextLoads() {
		assertThat(handicraftController).isNotNull();
		assertThat(handicraftRestController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(categoryRestController).isNotNull();
		assertThat(sellerController).isNotNull();
		assertThat(sellerRestController).isNotNull();
	}

}
