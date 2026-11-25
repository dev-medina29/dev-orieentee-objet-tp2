package net.medina.jpa_demo;

import net.medina.jpa_demo.entities.Product;
import net.medina.jpa_demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

//ne pas oublier de mettre la version de lombook dans le fichier pop.xml
//ne pas oublier de configurer la base de donnees dans le fichier application.properties


@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(JpaDemoApplication.class, args);

    }

//    @Bean permet l'execution de la methode au demarrage
    @Bean
     CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            Product p1 = new Product();
            p1.setName("Computer");
            p1.setPrice(1000.0);
            p1.setQuantity(60);
            productRepository.save(p1);

//            -------------constructeur avec parametre-----------

            Product p2 = new Product(null,"Phone",400,33);
            productRepository.save(p2);

//           ------------ creation en utilisant builder ---------------

            Product p3= Product.builder().name("Printer").quantity(13).price(700).build();
            productRepository.save(p3);

            List<Product> productList = productRepository.findAll();
            productList.forEach(prod->{
                System.out.println(prod.getName());
            });
        };

    };

}
