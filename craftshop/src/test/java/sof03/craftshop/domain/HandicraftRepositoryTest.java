package sof03.craftshop.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HandicraftRepositoryTest {

	@Autowired
	private HandicraftRepository handicraftRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SellerRepository sellerRepository;

	// Testataan uuden käsityön (handicraft) luomista
	@Test
	public void createNewHandicraft() {
		Category category = new Category("Pottery");
		categoryRepository.save(category);
		Seller seller = new Seller("Anna", "045 9283 6371", "anna@annala.fi");
		sellerRepository.save(seller);
		Handicraft handicraft = new Handicraft("Rainbow mug", "A mug in rainbow colors!", category, 15L, seller);
		handicraftRepository.save(handicraft);
		assertThat(handicraft.getId()).isNotNull();
	}

	// Testataan valmiiden käsitöiden etsimistä
	@Test
	public void searchForHandicrafts() {
		List<Handicraft> handicrafts = new ArrayList<>();
		Handicraft handicraft1 = handicraftRepository.findById(1L).get();
		Handicraft handicraft2 = handicraftRepository.findById(2L).get();
		Handicraft handicraft3 = handicraftRepository.findById(3L).get();
		Handicraft handicraft4 = handicraftRepository.findById(4L).get();
		if (handicraft1 != null && handicraft2 != null && handicraft3 != null && handicraft4 != null) {
			handicrafts.add(handicraft1);
			handicrafts.add(handicraft2);
			handicrafts.add(handicraft3);
			handicrafts.add(handicraft4);
		}
		assertThat(handicrafts).contains(handicraft1, handicraft2, handicraft3, handicraft4);
	}

	// Testataan käsityön poistamista
	@Test
	public void deleteHandicraft() {
		Handicraft handicraft = handicraftRepository.findById(5L).get();
		handicraftRepository.deleteById(handicraft.getId());
		assertThat(handicraftRepository.findById(handicraft.getId())).isEmpty();
	}
}
