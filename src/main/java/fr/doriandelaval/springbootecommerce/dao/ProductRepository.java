package fr.doriandelaval.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.doriandelaval.springbootecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    
}
