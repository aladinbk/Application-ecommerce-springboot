package org.sid.backendleDeal.web;

import java.util.List;

import org.sid.backendleDeal.dao.AchatItemRepository;
import org.sid.backendleDeal.entities.AchatItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Commandedeals {	
	
	@Autowired
	private AchatItemRepository achatitemRepository;

	
	
	@GetMapping(value = "/listcommandesdeals")
	public List<AchatItem> Listcommandes() {
		return achatitemRepository.findAll();
	}
}
