package org.sid.backendleDeal.dao;

import org.sid.backendleDeal.entities.AchatItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface AchatItemRepository extends JpaRepository<AchatItem, Long>{

}
