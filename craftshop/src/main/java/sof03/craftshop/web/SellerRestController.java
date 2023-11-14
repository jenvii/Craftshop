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

import sof03.craftshop.domain.Seller;
import sof03.craftshop.domain.SellerRepository;

@CrossOrigin
@Controller
public class SellerRestController {

	@Autowired
	private SellerRepository sellerRepository;

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
