package raph.dev.springboot_rest_api_demo_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raph.dev.springboot_rest_api_demo_1.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
