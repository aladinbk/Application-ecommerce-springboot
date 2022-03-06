package org.sid.backendleDeal.dao;

import java.util.List;
import java.util.Optional;

import org.sid.backendleDeal.entities.Client;
import org.sid.backendleDeal.entities.Offres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@RestResource(path="/clientByKeyword")
	public List<Client>findByNameContains(@Param("mc")String mc);
	
	@RestResource(path="/byNamepage")
	public Page<Client>findByNameContains(@Param("mc")String mc,Pageable pageable);
	boolean existsByEmail(String email);

	Optional<Client> findOneByEmailAndPassword(String email, String password);

}
