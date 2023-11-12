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
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository categoryRepository;

	// Testataan uuden kategorian luomista
	@Test
	public void createNewCategory() {
		Category category = new Category("Pottery");
		categoryRepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}

	// Testataan kolmen kategorian etsimistä
	@Test
	public void searchForCategories() {
		List<Category> categories = new ArrayList<>();
		Category category1 = categoryRepository.findById(1L).get();
		Category category2 = categoryRepository.findById(2L).get();
		Category category3 = categoryRepository.findById(3L).get();
		if (category1 != null && category2 != null && category3 != null) {
			categories.add(category1);
			categories.add(category2);
			categories.add(category3);
		}
		assertThat(categories).contains(category1, category2, category3);
	}
	
	// Testataan neljännen kategorian poistamista
	@Test
	public void deleteCategory() {
		Category category = categoryRepository.findById(4L).get();
		categoryRepository.deleteById(category.getCategoryid());
		assertThat(categoryRepository.findById(category.getCategoryid())).isEmpty();
	}
}
