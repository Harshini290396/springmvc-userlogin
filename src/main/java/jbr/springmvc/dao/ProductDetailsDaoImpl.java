package jbr.springmvc.dao;

import jbr.springmvc.model.Description;
import jbr.springmvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ProductDetailsDaoImpl implements ProductDetailsDao {

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;





    public List<Product> productDescription(String model){
        String sql="select * from product where model='"+ model + "'";
        List list=jdbcTemplate.queryForList(sql);

        return list;

    }

    public List<Product> modelYear(int modelFrom,int modelTo,String categoryName){
        String sql="select * from product_category c inner join product p on c.id = p.category_id where category_name='"+ categoryName + "' and model_year between"+modelFrom+" and "+modelTo;
        List list=jdbcTemplate.queryForList(sql);

        return list;

    }

}

