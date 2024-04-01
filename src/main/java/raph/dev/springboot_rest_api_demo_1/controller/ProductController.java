package raph.dev.springboot_rest_api_demo_1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import raph.dev.springboot_rest_api_demo_1.model.Product;
import raph.dev.springboot_rest_api_demo_1.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {
    /* here its an inversion of controller
        because we go through the interface to call the methods of service implements
     */
    private final ProductService productService;
    /*
        the controller does not this method
        to map it to HTTP we added @PostMapping
        and give a path

        to add the data to the body of the request we use
        @RequestBody (as JSON object)
     */
    @PostMapping("/createproduct")
    public Product createproduct(@RequestBody Product product){
        return productService.create(product);
    }
    /*
        we are now getting data from database so we map with
        @GetMapping
    */
    @GetMapping("/readproduct")
    public List<Product> readproduct(){
        return  productService.display();
    }
    /*
        since its an update we use the put method
        we have path variable in the path
     */
    @PutMapping("/updateproduct/{id}")
    public Product updateproduct(@PathVariable Long id, @RequestBody Product product){
        return productService.update(id,product);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public String deleteproduct(@PathVariable Long id){
        return productService.delete(id);
    }
}
