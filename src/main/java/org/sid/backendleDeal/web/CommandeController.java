package org.sid.backendleDeal.web;

import java.util.Date;
import java.util.List;

import org.sid.backendleDeal.dao.AchatItemRepository;
import org.sid.backendleDeal.dao.ClientRepository;
import org.sid.backendleDeal.dao.CommandeRepository;
import org.sid.backendleDeal.dao.OffresRepository;
import org.sid.backendleDeal.entities.AchatItem;
import org.sid.backendleDeal.entities.Client;
import org.sid.backendleDeal.entities.Commande;
import org.sid.backendleDeal.entities.Offres;
import org.sid.backendleDeal.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class CommandeController {

	@Autowired
	private OffresRepository offresRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CommandeRepository commandeRepository;

	@Autowired
	private AchatItemRepository achatitemRepository;

	@Autowired
	private CommandeService commandeService;

	@PostMapping(path = "/orders")
	public Commande SaveCommande(@RequestBody CommandeForm commandeForm) {

		Client client = new Client();

		client.setName(commandeForm.getClient().getName());
		client.setEmail(commandeForm.getClient().getEmail());
		client.setAdresse(commandeForm.getClient().getAdresse());
		client.setPhonenumber(commandeForm.getClient().getPhonenumber());

		client = clientRepository.save(client);

		System.out.println(client.getId());

		Commande commande = new Commande();
		commande.setClient(client);
		commande.setDate(new Date());
		commande = commandeRepository.save(commande);

		double total = 0;
		System.out.println("ok");

		for (CommandeOffre p : commandeForm.getOffreses()) {
			AchatItem achatitem = new AchatItem();
			System.out.println("ok1");
			achatitem.setCommande(commande);
			Offres offres = offresRepository.findById(p.getId()).get();

			System.out.println(offresRepository.findById(p.getId()).get());

			achatitem.setOffres(offres);
			achatitem.setPrice(offres.getCurrentprice());
			achatitem.setQuantity(p.getQuantity());
			achatitemRepository.save(achatitem);

			total += p.getQuantity() * offres.getCurrentprice();

		}

		commande.setTotalAmount(total);
		return commandeRepository.save(commande);

	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Commande commande = commandeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
		return ResponseEntity.ok().body(commande);
	}

	@GetMapping(value = "/listcommandes")
	public List<Commande> Listcommandes() {
		return commandeRepository.findAll();
	}

	@RequestMapping("/commande/count")
	private Long getNumberOfCommandes() {
		return commandeRepository.count();
	}

	@RequestMapping("/client/count")
	private Long getNumberOfClients() {
		return clientRepository.count();
	}

	@PostMapping("/commande")
	public Commande commander(@RequestBody Commande commande) {
		return commandeService.commander(commande);
	}
	
	@GetMapping(value="/commande/{id}")
	public List<Commande> listcommandes(@PathVariable(name="id") Long id ){
		return (List<Commande>) commandeRepository.findById(id).get();
	}
	@RequestMapping(value="/commandes/{id}",method=RequestMethod.PUT) 
	public Commande save(@PathVariable Long id,  @RequestBody Commande c){
	    c.setId(id);
		return commandeRepository.save(c);
	}

}
