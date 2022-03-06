package org.sid.backendleDeal.services;

import java.util.Date;
import java.util.List;

import org.sid.backendleDeal.dao.AchatItemRepository;
import org.sid.backendleDeal.dao.CommandeRepository;
import org.sid.backendleDeal.entities.AchatItem;
import org.sid.backendleDeal.entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private AchatItemRepository achatItemRepository;

	public Commande commander(Commande commande) {

		commande.setDate(new Date());
		commande.setEtatcommande("Non Payé");
		commandeRepository.save(commande);

		for (AchatItem achat : commande.getAchatsItems()) {
			achat.setCommande(commande);
			achatItemRepository.save(achat);
		}

		return commande;
	}
	
	
}
