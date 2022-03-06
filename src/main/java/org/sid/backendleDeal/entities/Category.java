package org.sid.backendleDeal.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_c;
	private String name;
	private String photo;
	private String description; 
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private Collection <Offres> offrees;

	
	
	
}
