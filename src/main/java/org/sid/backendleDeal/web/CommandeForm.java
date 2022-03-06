package org.sid.backendleDeal.web;

import java.util.ArrayList;
import java.util.List;

import org.sid.backendleDeal.entities.Client;

import lombok.Data;


@Data
public class CommandeForm {
    private Client client=new Client();
	private List<CommandeOffre> Offreses=new ArrayList<>();
	public CommandeForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommandeForm(Client client, List<CommandeOffre> offreses) {
		super();
		this.client = client;
		Offreses = offreses;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<CommandeOffre> getOffreses() {
		return Offreses;
	}
	public void setOffreses(List<CommandeOffre> offreses) {
		Offreses = offreses;
	}
	
	
	
}

@Data
class CommandeOffre {
	private Long id;
	private int quantity;
	public CommandeOffre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommandeOffre(Long id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}


