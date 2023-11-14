package sof03.craftshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import sof03.craftshop.domain.HandicraftRepository;
import sof03.craftshop.domain.Seller;
import sof03.craftshop.domain.SellerRepository;
import sof03.craftshop.domain.CategoryRepository;
import sof03.craftshop.domain.Handicraft;

@Controller
public class HandicraftController {

	@Autowired
	HandicraftRepository handicraftRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SellerRepository sellerRepository;

	// Sovelluksen aloitusnäkymä, jossa on listattuna kaikki myynnissä olevat tuotteet
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String handictaftList(Model model) {
		model.addAttribute("handicrafts", handicraftRepository.findAll());
		return "handicraftlist";
	}

	// Palauttaa uusien tuotteiden lisäyslomakkeen
	@PreAuthorize("hasAuthority('SELLER')")
	@RequestMapping(value = "/add")
	public String addHandicraft(Model model) {
		Handicraft handicraft = new Handicraft();
		Seller seller = new Seller();
		handicraft.setSeller(seller);
		model.addAttribute("handicraft", handicraft);
		model.addAttribute("categories", categoryRepository.findAll());
		return "addhandicraft";
	}

	// Tallentaa uuden tuotteen ja myyjän tuotteelle
	@PreAuthorize("hasAuthority('SELLER')")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHandicraft(@Valid Handicraft handicraft, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", categoryRepository.findAll());
			return "addhandicraft";
		}
		Seller seller = handicraft.getSeller();
		sellerRepository.save(seller);
		handicraftRepository.save(handicraft);
		return "redirect:/shop";
	}

	// Poistaa tuotteen
	@PreAuthorize("hasAuthority('SELLER')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteHandicraft(@PathVariable("id") Long handicraftId, Model model) {
		handicraftRepository.deleteById(handicraftId);
		return "redirect:/shop";
	}

	// Palauttaa tuotteen editointilomakkeen
	@PreAuthorize("hasAuthority('SELLER')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editHandicraft(@PathVariable("id") Long handicraftId, Model model) {
		Handicraft handicraft = handicraftRepository.findById(handicraftId).orElse(null);
		model.addAttribute("handicraft", handicraft);
		model.addAttribute("categories", categoryRepository.findAll());
		return "edithandicraft";
	}

	// Tallentaa editoidun tuotteen
	@PreAuthorize("hasAuthority('SELLER')")
	@RequestMapping(value = "/saveedits", method = RequestMethod.POST)
	public String saveEditedHandicraft(@Valid Handicraft handicraft, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", categoryRepository.findAll());
			return "edithandicraft";
		}
		Seller seller = handicraft.getSeller();
		sellerRepository.save(seller);
		handicraftRepository.save(handicraft);
		return "redirect:/shop";
	}

	// Palauttaa virhesivun
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Model model) {
		return "error";
	}
}
