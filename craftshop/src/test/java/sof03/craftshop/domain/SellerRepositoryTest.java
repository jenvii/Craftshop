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
public class SellerRepositoryTest {

	@Autowired
	private SellerRepository sellerRepository;

	// Testataan myyjän (seller) luomista
	@Test
	public void createNewSeller() {
		Seller seller = new Seller("Maria", "050 7663 2837", "marja@marjanen.fi");
		sellerRepository.save(seller);
		assertThat(seller.getSellerId()).isNotNull();
	}

	// Testataan kolmen myyjän etsimistä
	@Test
	public void searchForSellers() {
		List<Seller> sellers = new ArrayList<>();
		Seller seller1 = sellerRepository.findById(1L).get();
		Seller seller2 = sellerRepository.findById(2L).get();
		Seller seller4 = sellerRepository.findById(4L).get();
		if (seller1 != null && seller2 != null && seller4 != null) {
			sellers.add(seller1);
			sellers.add(seller2);
			sellers.add(seller4);
		}
		assertThat(sellers).contains(seller1, seller2, seller4);
	}
	
	// Testataan jäljelle jääneen myyjän poistoa
	@Test
	public void deleteSeller() {
		Seller seller3 = sellerRepository.findById(3L).get();
		sellerRepository.deleteById(seller3.getSellerId());
		assertThat(sellerRepository.findById(seller3.getSellerId())).isEmpty();
		
	}
	
}
