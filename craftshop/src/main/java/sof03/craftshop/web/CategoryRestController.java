package sof03.craftshop.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sof03.craftshop.domain.Category;
import sof03.craftshop.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryRestController {

	@Autowired
	private CategoryRepository categoryRepository;

	// Kaikki kategoriat JSON-muodossa REST:n avulla.
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> categoryListRest() {
		return (List<Category>) categoryRepository.findAll();
	}

	// Tietyn kategorian etsiminen id:llä JSON-muodossa REST:n avulla.
	@RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("categoryId") Long categoryId) {
		return categoryRepository.findById(categoryId);
	}

}
