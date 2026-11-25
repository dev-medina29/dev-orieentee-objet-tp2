package net.medina.jpa_demo.repository;

import net.medina.jpa_demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByNameContains(String nm);


}
