package org.sid.backendleDeal.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.sid.backendleDeal.dao.CategoryRepository;
import org.sid.backendleDeal.dao.ClientRepository;
import org.sid.backendleDeal.dao.OffresRepository;
import org.sid.backendleDeal.entities.Category;
import org.sid.backendleDeal.entities.Client;
import org.sid.backendleDeal.entities.Commande;
import org.sid.backendleDeal.entities.Offres;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;
@CrossOrigin("*")
@RestController
public class CatalogueController {
	private OffresRepository offresRepository ;
    private CategoryRepository catRepository;
    private ClientRepository clRepository;
	public CatalogueController(OffresRepository offresRepository,CategoryRepository catRepository , ClientRepository clRepository) {
		this.offresRepository = offresRepository;
		this.catRepository=catRepository;
		this.clRepository=clRepository;
	}

	@RequestMapping(value="/clients/{id}",method=RequestMethod.PUT)
	public Client save(@PathVariable Long id, @RequestBody Client c) {
		c.setId(id);
		return clRepository.save(c);
	}
	
	
	@GetMapping(value="/listclient/{id}")
	public List<Client> listclients(@PathVariable(name="id") Long id ){
		return (List<Client>) clRepository.findById(id).get();
	}
	@GetMapping("/Client/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long id)
	 throws ResourceNotFoundException {
	 Client client = clRepository.findById(id)
	   .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
	 return ResponseEntity.ok().body(client);
	}
	
	
	
	/*Web api REST Get GettouslesCategories */
	@GetMapping(value="/listCategories")
	public List<Category> Listcategories(){
		return catRepository.findAll();
	}
	@GetMapping("/Category/{id_c}")
	public ResponseEntity<Category> getCategoryById_c(@PathVariable(value = "id_c") Long id_c)
			throws ResourceNotFoundException {
		Category category = catRepository.findById(id_c)
				.orElseThrow(() -> new ResourceNotFoundException("Cat not found for this id :: " + id_c));
		return ResponseEntity.ok().body(category);
	}
	
	
	@RequestMapping(value="/modcategorie/{id_c}",method=RequestMethod.PUT) 
	public Category save(@PathVariable Long id_c,  @RequestBody Category c){
	   c.setId_c(id_c);
		return catRepository.save(c);
	}
	/*Web api REST Get GettouslesOffres */
	@GetMapping(value="/listOffres")
	public List<Offres> listOffres(){
		return offresRepository.findAll();
	}
	/*Web api REST Get GetUnOffre avec Id */
	@GetMapping(value="/listOffres/{id}")
	public List<Offres> listOffres(@PathVariable(name="id") Long id ){
		return (List<Offres>) offresRepository.findById(id).get();
	}
	/*Web api REST Get GetUnCategory avec Id */
	@GetMapping(value="/listCategories/{id}")
	public List<Category> listCategories(@PathVariable(name="id") Long id ){
		return (List<Category>) catRepository.findById(id).get();
	}
	/*Web api REST POST Ajouter Un Offre */
	/*@PostMapping(value="/listOffres")
	public Offres save(@RequestBody Offres O) {
		return offresRepository.save(O);
	
	}*/
	@RequestMapping(value="/listOffres",method=RequestMethod.POST) 
	public Offres save(@RequestBody Offres o){
		 return offresRepository.save(o);
	}

	@RequestMapping(value="/addcat",method=RequestMethod.POST) 
	public Category savecat(@RequestBody Category c){
		 return catRepository.save(c);
	}
	
	
	
	/*Web api REST POST ajouter un Category*/
	@PostMapping(value="/listCategories")
	public Category save(@RequestBody Category c) {
		return catRepository.save(c);
	}
	/*Web api REST Delete Supprimer un OffresDansUneList En Spécifiant l'id*/
	@DeleteMapping(value="/listOffres/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		offresRepository.deleteById(id);
	} 
	/*Web api REST Delete Supprimer un OffresDansUneList En Spécifiant l'id*/
	@DeleteMapping(value="/listCategories/{id}")
	public void deleteCat(@PathVariable(name="id") Long id) {
		catRepository.deleteById(id);
	}  
	/* Web api REST Get getlesPhotosdesoffres*/
	@GetMapping(path="/photoOffres/{id}",produces = MediaType.IMAGE_PNG_VALUE)
      
	public byte[] getPhoto(@PathVariable("id") Long id) throws IOException{
    	  
		Offres o=offresRepository.findById(id).get();
		File serverFile = new File("C:\\Users\\Boubaker\\Offress\\"+o.getPhotoName());
        System.out.println("serverFile : " + serverFile);        
        return Files.readAllBytes(serverFile.toPath());
		
    }
	/* Web api REST Post UploadPhotoPourUnOffre dans un Dosier Offres et Enregistrer le nom du Photo Avec Spring DataRest */
	@PostMapping(path = "/uploadPhoto/{id}")
	public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {
		
		Offres o=offresRepository.findById(id).get();
		o.setPhotoName(file.getOriginalFilename());
		Files.write(Paths.get(System.getProperty("user.home")+"\\Offress\\"+o.getPhotoName()),file.getBytes());
		offresRepository.save(o);
		
	}
	@PostMapping(path = "/uploadphotoOffre")
	public void addPhotoTooffre(MultipartFile file, @PathVariable Long id) throws Exception {
		
		Offres o=offresRepository.findById(id).get();
		o.setPhotoName(file.getOriginalFilename());
		Files.write(Paths.get(System.getProperty("user.home")+"\\Offress\\"+o.getPhotoName()),file.getBytes());
		offresRepository.save(o);
		
	}
	
	
}
