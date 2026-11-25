package net.medina.jpa_demo.web;

import net.medina.jpa_demo.entities.Product;
import net.medina.jpa_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> allProducts(){
        List<Product> products=productRepository.findAll();
        return products;
    };
    @GetMapping("/products/{id}")
    public Product productById(@PathVariable Long id){
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Product not found")
        );
        return product;

    };
    @GetMapping("/find/products")
    public List<Product> findProducts(@RequestParam(name="h",defaultValue = "") String h){
        return productRepository.findByNameContains(h);
    }

    @PostMapping("/products")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
