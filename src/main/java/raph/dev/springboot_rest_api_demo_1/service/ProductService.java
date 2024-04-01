package raph.dev.springboot_rest_api_demo_1.service;

import raph.dev.springboot_rest_api_demo_1.model.Product;

import java.util.List;

public interface ProductService {

    Product create (Product product);

    List<Product> display ();

    Product update(Long id, Product product);

    String delete (Long id);
}
