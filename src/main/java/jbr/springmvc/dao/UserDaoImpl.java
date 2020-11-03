package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {
    String sql = "insert into users values(?,?,?)";

    return jdbcTemplate.update(sql, new Object[]{user.getUsername(), user.getPassword(), user.getEmail()});
  }

  public User validateUser(Login login) {
    String sql="";
    if(login.getUsername().contains(".")){
    sql = "select * from users where email='" + login.getUsername() + "' and password='" + login.getPassword()
            + "'";
    }
    else{
      sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
              + "'";
    }
    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }

  public List<User> getAllUsers() {

    String sql = "SELECT * FROM users";
    List<User> listUser = jdbcTemplate.query(sql, new UserMapper());
    return listUser;

  }
}



class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setEmail(rs.getString("email"));

    return user;
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
