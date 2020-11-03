package jbr.springmvc.service;

import jbr.springmvc.model.Description;
import jbr.springmvc.model.Product;

import java.util.List;

public interface ProductDetailsService {

    public List<Product> productDescription(String model);
    public List<Product> modelYear(int modelFrom,int modelTo,String categoryName);
}
