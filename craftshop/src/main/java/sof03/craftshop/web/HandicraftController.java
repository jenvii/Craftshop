package sof03.craftshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sof03.craftshop.domain.HandicraftRepository;

@Controller
public class HandicraftController {

	@Autowired
	HandicraftRepository handicraftRepository;
	
	@RequestMapping("/shop")
	public String handictaftList(Model model) {
		model.addAttribute("handicrafts", handicraftRepository.findAll());
		return "handicraftlist";
	}
	
	
}
