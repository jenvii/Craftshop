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

import sof03.craftshop.domain.Handicraft;
import sof03.craftshop.domain.HandicraftRepository;

@CrossOrigin
@Controller
public class HandicraftRestController {

	@Autowired
	private HandicraftRepository handicraftRepository;

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

}
