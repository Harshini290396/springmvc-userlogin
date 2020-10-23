package jbr.springmvc.service;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

  int register(User user);

  User validateUser(Login login);

  List<User> getAllUsers();
}
