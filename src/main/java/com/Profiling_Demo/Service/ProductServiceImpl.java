package com.Profiling_Demo.Service;

import com.Profiling_Demo.Entity.Product;
import com.Profiling_Demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService, ProfileDemoService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product Item Deleted";
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product product1 = productRepository.findById(id).get();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setPrice(product.getPrice());
        productRepository.save(product1);
        return product1;
    }

    @Value("${application.welcome.message}")
    private String message;

    @Override
    public String getWelcomeMessage() throws Exception {
        return message;
    }
}
