package com.Profiling_Demo.Service;

import com.Profiling_Demo.Entity.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProduct(int id);

    public String deleteProduct(int id);

    public Product updateProduct(int id, Product product);

}
