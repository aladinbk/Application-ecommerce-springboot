package org.sid.backendleDeal.dao;

import org.sid.backendleDeal.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface CommandeRepository  extends JpaRepository<Commande, Long> {

}
