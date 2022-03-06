package org.sid.backendleDeal.services;

import org.sid.backendleDeal.dao.ClientRepository;
import org.sid.backendleDeal.entities.Client;
import org.sid.backendleDeal.model.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public MessageResponse save(Client client) {

		boolean exist = clientRepository.existsByEmail(client.getEmail());

		if (exist) {
			return new MessageResponse(false, "Email existe déja");

		}

		client.setRole("Client");
		clientRepository.save(client);
		return new MessageResponse(true, "Opération effectuée");

	}

	public Client authenticate(Client client) {

		Client clt = clientRepository.findOneByEmailAndPassword(client.getEmail(), client.getPassword()).orElse(null);

		return clt;
	}
}
