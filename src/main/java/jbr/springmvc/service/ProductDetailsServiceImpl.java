package jbr.springmvc.service;


import jbr.springmvc.dao.ProductDetailsDao;
import jbr.springmvc.model.Description;
import jbr.springmvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductDetailsServiceImpl implements ProductDetailsService{


    @Autowired
    public ProductDetailsDao productDetailsDao;


    @Transactional
    public List<Product> productDescription(String model){
        return productDetailsDao.productDescription(model);
    }

    public List<Product> modelYear(int modelFrom,int modelTo,String categoryName){return productDetailsDao.modelYear(modelFrom,modelTo,categoryName);}
}
