package org.sid.backendleDeal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;



@Data 

@Entity

public class Client {

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String adresse;
	private String phonenumber;
	private String password;
	private String role;
	
	
	
}
