package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RegistrationController {
  @Autowired
  public UserService userService;



  @Autowired
  JdbcTemplate jdbcTemplate;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    //mav.addObject("user", new User());

    return mav;
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user) {

    userService.register(user);

    return new ModelAndView("welcome", "firstname", user.getUsername());
  }

  @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
  public String registerUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String email) {

    User user=new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    userService.register(user);

    return "success";
  }

  @ResponseBody
  @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
  public List<User> getUsers() {

    List<User> listUser = userService.getAllUsers();

    return listUser;
  }
}


/* List<String> str=new ArrayList<String>();

    List<User> listUser = userService.getAllUsers();
    for(int i=0;i<listUser.size();i++){
      str.add(listUser.get(i).getUsername());
    }
    return str;
    */
