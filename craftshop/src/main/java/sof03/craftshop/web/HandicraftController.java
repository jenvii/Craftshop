package sof03.craftshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sof03.craftshop.domain.HandicraftRepository;
import sof03.craftshop.domain.Handicraft;

@Controller
public class HandicraftController {

	@Autowired
	HandicraftRepository handicraftRepository;

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String handictaftList(Model model) {
		model.addAttribute("handicrafts", handicraftRepository.findAll());
		return "handicraftlist";
	}
	
	@RequestMapping(value = "/add")
	public String addHandicraft(Model model) {
		model.addAttribute("handicraft", new Handicraft());
		return "addhandicraft";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHandicraft(Handicraft handicraft) {
		handicraftRepository.save(handicraft);
		return "redirect:shop";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteHandicraft(@PathVariable("id") Long handicraftId, Model model) {
		handicraftRepository.deleteById(handicraftId);
		return "redirect:/shop";
	}

}
