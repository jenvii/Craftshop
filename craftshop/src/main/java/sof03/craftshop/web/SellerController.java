package sof03.craftshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sof03.craftshop.domain.Handicraft;
import sof03.craftshop.domain.HandicraftRepository;
import sof03.craftshop.domain.Seller;

@Controller
public class SellerController {

	@Autowired
	HandicraftRepository handicraftRepository;

	// Palauttaa tietyn tuotteen myyjän tiedot
	@RequestMapping(value = "/seller/{id}")
	public String findSellerInfo(@PathVariable("id") Long handicraftId, Model model) {
		Handicraft handicraft = handicraftRepository.findById(handicraftId).orElse(null);
		Seller seller = handicraft.getSeller();
		model.addAttribute("seller", seller);
		model.addAttribute("handicraft", handicraft);
		return "sellerinfo";
	}
}
