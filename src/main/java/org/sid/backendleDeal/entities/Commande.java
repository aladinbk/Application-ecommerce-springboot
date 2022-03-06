package org.sid.backendleDeal.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Table(name="commandes")
@Entity
public class Commande {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;

	@OneToMany (mappedBy = "commande")
	private Collection<AchatItem> achatsItems;
	@ManyToOne 
	private Client client;
	private double totalAmount;
	private String etatcommande;
	
	
	
	
}
