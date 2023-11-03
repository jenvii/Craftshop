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
import sof03.craftshop.domain.Handicraft;
import sof03.craftshop.domain.HandicraftRepository;
import sof03.craftshop.domain.Seller;
import sof03.craftshop.domain.SellerRepository;

@CrossOrigin
@Controller
public class HandicraftRestController {

	@Autowired
	private HandicraftRepository handicraftRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SellerRepository sellerRepository;

	// Kaikki käsityöt JSON-muodossa REST:n avulla.
	@RequestMapping(value = "/handicrafts", method = RequestMethod.GET)
	public @ResponseBody List<Handicraft> handicraftListRest() {
		return (List<Handicraft>) handicraftRepository.findAll();
	}

	// Tietyn käsityön etsiminen id:llä JSON-muodossa REST:n avulla.
	@RequestMapping(value = "/handicrafts/{handicraftId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Handicraft> findHandicraftRest(@PathVariable("handicraftId") Long handicraftId) {
		return handicraftRepository.findById(handicraftId);
	}

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

	// Kaikki myyjät JSON-muodossa REST:n avulla.
	@RequestMapping(value = "/sellers", method = RequestMethod.GET)
	public @ResponseBody List<Seller> sellerListRest() {
		return (List<Seller>) sellerRepository.findAll();
	}

	// Tietyn myyjän etsiminen id:llä JSON-muodossa REST:n avulla.
	@RequestMapping(value = "/sellers/{sellerId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Seller> findSellerRest(@PathVariable("sellerId") Long sellerId) {
		return sellerRepository.findById(sellerId);
	}
}
