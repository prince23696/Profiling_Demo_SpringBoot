package com.Profiling_Demo.Controller;

import com.Profiling_Demo.Entity.Product;
import com.Profiling_Demo.Service.ProductService;
import com.Profiling_Demo.Service.ProfileDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProfileDemoService profileDemoService;

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() throws Exception {
        String welcomeMessage = profileDemoService.getWelcomeMessage();
        ResponseEntity<String> response = new ResponseEntity<>(welcomeMessage, HttpStatus.OK);
        return response;
    }

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/deleteProduct/{id]")
    public String saveProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Product Deleted from Database id : " + id;
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
