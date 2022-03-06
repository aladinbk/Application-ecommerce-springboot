package org.sid.backendleDeal;

import java.util.Random;

import org.sid.backendleDeal.dao.CategoryRepository;
import org.sid.backendleDeal.dao.OffresRepository;
import org.sid.backendleDeal.entities.Category;
import org.sid.backendleDeal.entities.Offres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import net.bytebuddy.utility.RandomString;
@SpringBootApplication

public class BackendLedealMain implements CommandLineRunner{
	@Autowired
	private OffresRepository offresRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
 
    
	public static void main(String[] args) {
		SpringApplication.run(BackendLedealMain.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Offres.class,Category.class);
		
		
//	    categoryRepository.save(new Category(null,"Beauté remise en Forme",null,null,null));
//		categoryRepository.save(new Category(null,"Sortie et loisirs",null,null,null));
//		categoryRepository.save(new Category(null," Formations et apprentissages",null,null,null));
//		categoryRepository.save(new Category(null,"hôtels",null,null,null));
//	    categoryRepository.save(new Category(null,"Shopping",null,null,null));
//		Random rnd=new Random();
//		categoryRepository.findAll().forEach(c->{
//        for(int i=0;i<10;i++) {
//           Offres o=new Offres();
//			
//			o.setName(RandomString.make(18));
//	        o.setCurrentprice(100+rnd.nextInt(10000));
//			o.setAvailable(rnd.nextBoolean());
//    		o.setPromotion(rnd.nextBoolean());
//			o.setSelected(rnd.nextBoolean());
//	     	o.setCategory(c);
//     		o.setPhotoName("unknowm.png");
//			offresRepository.save(o);
//        }		
//			
//		});		
	}

}
