package sof03.craftshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import sof03.craftshop.domain.CategoryRepository;
import sof03.craftshop.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	// Palauttaa lomakkeen kategorian lisäämiselle
	@PreAuthorize("hasAuthority('SELLER')")
	@RequestMapping(value = "/addcategory")
	public String AddCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	// Tallentaa lisätyn kategorian
	@PreAuthorize("hasAuthority('SELLER')")
	@RequestMapping(value="/savecategory", method = RequestMethod.POST)
	public String saveCategory(@Valid Category category, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addcategory";
		}
		categoryRepository.save(category);
		return "redirect:add";
	}
}
