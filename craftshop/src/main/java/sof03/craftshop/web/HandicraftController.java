package sof03.craftshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String handictaftList(Model model) {
		model.addAttribute("handicrafts", handicraftRepository.findAll());
		return "handicraftlist";
	}
	
	@RequestMapping(value = "/add")
	public String addHandicraft(Model model) {
		Handicraft handicraft = new Handicraft();
        Seller seller = new Seller();
		model.addAttribute("handicraft", handicraft);
	    model.addAttribute("seller", seller);
	    model.addAttribute("categories", categoryRepository.findAll());
	    return "addhandicraft";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHandicraft(Handicraft handicraft, Seller seller) {
		handicraft.setSeller(seller);
	    sellerRepository.save(seller);
	    handicraftRepository.save(handicraft);
	    return "redirect:/shop";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteHandicraft(@PathVariable("id") Long handicraftId, Model model) {
		handicraftRepository.deleteById(handicraftId);
		return "redirect:/shop";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editHandicraft(@PathVariable("id") Long handicraftId, Model model) {
		Handicraft handicraft = handicraftRepository.findById(handicraftId).orElse(null);
		model.addAttribute("handicraft", handicraft);
		model.addAttribute("categories", categoryRepository.findAll());
		return "edithandicraft";
	}
}
