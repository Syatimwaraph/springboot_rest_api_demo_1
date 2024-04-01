package raph.dev.springboot_rest_api_demo_1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raph.dev.springboot_rest_api_demo_1.model.Product;
import raph.dev.springboot_rest_api_demo_1.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor // from lombok
public class ProductServiceImplement  implements ProductService{
    // to inject the repository by constructor
    private  final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> display() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Long id, Product product) {
        return productRepository.findById(id)
                .map(prod->{
                    prod.setId(product.getId());
                    prod.setName(product.getName());
                    prod.setDescription(product.getDescription());

                    return productRepository.save(prod);
        }).orElseThrow(() -> new RuntimeException("Sorry! Product Not Found!!"));
    }

    @Override
    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Product Deleted";
    }
}
