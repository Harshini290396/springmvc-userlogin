package jbr.springmvc.controller;

import jbr.springmvc.model.Description;
import jbr.springmvc.model.Product;
import jbr.springmvc.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
public class ProductDetailsController {

    @Autowired
    public ProductDetailsService prod;

    @RequestMapping(value = "/productDescription", method = RequestMethod.GET, produces = "application/json")
    public List<Product> productDesc(String model){

        List<Product> list =prod.productDescription(model);
        return list;
    }
}
