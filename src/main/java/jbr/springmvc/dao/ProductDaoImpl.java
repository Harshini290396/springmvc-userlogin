package jbr.springmvc.dao;

import jbr.springmvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class ProductDaoImpl implements ProductDao {

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts() {

        String sql = "SELECT product_id,product_name,details,document,contact FROM product where product_id=1";
        String sql1 = "select p.product_id,product_name,details,document,contact,manufacturer, series, model from product p inner join description d on p.product_id = d.product_id";
        //List<Product> list = jdbcTemplate.query(sql1, new ProductMapper());
        List list=jdbcTemplate.queryForList(sql1);

        return list;

    }

    public List<Product> categorySearch(String categoryName){

        String sql="select * from product_category c inner join product p on c.id = p.category_id where category_name='"+ categoryName + "'";


        List list=jdbcTemplate.queryForList(sql);

        return list;

    }

    public List<Product> getCategoryList(){

        String sql="select * from product_category ";
        List list=jdbcTemplate.queryForList(sql);
        return list;
    }

    public List<Product> productCompare(String model){
        String sql="select * from product where model='"+ model + "'";
        List list=jdbcTemplate.queryForList(sql);

        return list;

    }

}



class ProductMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int arg1) throws SQLException {


        Product product = new Product();
        product.setProduct_id(rs.getInt("product_id"));
        product.setProduct_name(rs.getString("product_name"));
        product.setDetails(rs.getString("details"));
        product.setDocument(rs.getString("document"));
        product.setContact(rs.getString("contact"));

        return product;
    }
}

   /*System.out.println(listUser);
    List<User> l=new ArrayList<>();

    for(int i=0;i<listUser.size();i++){
      User u=new User();
      u.setUsername(listUser.get(i).getUsername());
      System.out.println(listUser.get(i).getUsername());
      u.setPassword(listUser.get(i).getPassword());
      u.setEmail(listUser.get(i).getEmail());
      System.out.println(u);
      l.add(u);
    }*/
