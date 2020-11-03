package jbr.springmvc.service;

import jbr.springmvc.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public List<Product> categorySearch(String categoryName);
    public List<Product> getCategoryList();
    public List<Product> productCompare(String model);
}
