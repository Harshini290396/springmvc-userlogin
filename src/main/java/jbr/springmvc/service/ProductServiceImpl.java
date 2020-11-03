package jbr.springmvc.service;

import jbr.springmvc.dao.ProductDao;
import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.Product;
import jbr.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductServiceImpl implements ProductService{


    @Autowired
    public ProductDao productDao;


    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public List<Product> categorySearch(String categoryName){
        return productDao.categorySearch(categoryName);
    }

    public List<Product> getCategoryList(){
        return productDao.getCategoryList();
    }

    public List<Product> productCompare(String model){
        return productDao.productCompare(model);
    }
}
