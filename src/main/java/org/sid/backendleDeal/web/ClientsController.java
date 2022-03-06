package org.sid.backendleDeal.web;

import java.util.List;

import org.sid.backendleDeal.dao.ClientRepository;
import org.sid.backendleDeal.entities.Client;
import org.sid.backendleDeal.model.MessageResponse;
import org.sid.backendleDeal.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ClientsController {
    private ClientRepository clientRepository;
    
    @Autowired
    private ClientService clientService;

	public ClientsController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@GetMapping(value="/client/{id}")
	public List<Client> listclient(@PathVariable(name="id") Long id ){
		return (List<Client>) clientRepository.findById(id).get();
	}
	@RequestMapping(value="/clients",method=RequestMethod.GET) 
	public List<Client>getU(){
		 List<Client> clients=clientRepository.findAll();
		 return clients;
	}
	@RequestMapping(value="/client/{id}",method=RequestMethod.PUT) 
	public Client save(@PathVariable Long id,  @RequestBody Client c){
	    c.setId(id);
		return clientRepository.save(c);
	}
	@RequestMapping(value="/addclient",method=RequestMethod.POST) 
	public MessageResponse save(@RequestBody Client c){
		 return clientService.save(c);
	}
	
	@PostMapping("/login")
	public Client authenticate(@RequestBody Client client) {
		return clientService.authenticate(client);
	}
	
	@DeleteMapping(value="/delteclient/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		clientRepository.deleteById(id);
	} 
	
	@GetMapping(value="/listclients")
	public List<Client> Listclients(){
		return clientRepository.findAll();
	}


}
