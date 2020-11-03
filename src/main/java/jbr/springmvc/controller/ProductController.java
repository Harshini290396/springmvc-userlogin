package jbr.springmvc.controller;

import jbr.springmvc.model.Product;
import jbr.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Product> getProducts() {

        List<Product> list = productService.getAllProducts();
        return list;
    }

    @RequestMapping(value = "/searchCategory", method = RequestMethod.GET, produces = "application/json")
    public List<Product> categorySearch(String categoryName){

        List<Product> list =productService.categorySearch(categoryName);
        return list;
    }

    @RequestMapping(value = "/getCategoryList", method = RequestMethod.GET, produces = "application/json")
    public List<Product> getCategoryList(){
        List<Product> list =productService.getCategoryList();
        return list;
    }


    @RequestMapping(value = "/productCompare", method = RequestMethod.GET, produces = "application/json")
    public List<Product> productCompare(String model){

        List<Product> list =productService.productCompare(model);
        return list;
    }
}



