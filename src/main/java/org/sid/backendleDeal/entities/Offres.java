package org.sid.backendleDeal.entities;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Entity
@Table(name = "Offres")
public class Offres implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lieu;
	private String description;
	private double currentprice;
	private boolean promotion;
	private boolean selected;
	private boolean available;
	private String photoName;
	private Date date_debut;
	private Date date_fin;
	private double comission;
	private double new_prix;
	
	@ManyToOne
	private Category category;
	
	private int quantity=1;
	
	
	
}
