package sof03.craftshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandicraftController {

	@RequestMapping("/index")
	public String handictaftList(Model model) {
		return "handicraftlist";
	}
	
	
}
