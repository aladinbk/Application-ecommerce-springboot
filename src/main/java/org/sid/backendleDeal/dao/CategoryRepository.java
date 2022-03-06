package org.sid.backendleDeal.dao;

import java.util.List;

import org.sid.backendleDeal.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@RestResource(path="/categoryByKeyword")
	public List<Category>findByNameContains(@Param("mc")String mc);

}
