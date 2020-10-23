package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@RestController
public class LoginController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());

    return mav;
  }

  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("login") Login login) {
    ModelAndView mav = null;

    User user = userService.validateUser(login);

    if (null != user) {
      mav = new ModelAndView("welcome");
      mav.addObject("username", user.getUsername());
    } else {
      mav = new ModelAndView("login");
      mav.addObject("message", "Username or Password is wrong!!");
    }

    return mav;
  }

  @RequestMapping(value = "/loginUser", method = RequestMethod.POST, produces = "application/json")
  public String loginUser(@RequestParam String username,
                        @RequestParam String password) {
    Login login = new Login();
    login.setPassword(password);
    login.setUsername(username);

    User user = userService.validateUser(login);
  /*if(user!=null)
    return "true";
  else
    return "false";
  }*/

    User u=new User(user.getUsername(),user.getPassword(),user.getEmail());
   /* u.setUsername(user.getUsername());
    u.setPassword(user.getPassword());
    u.setEmail(user.getEmail());
   */

    return u.getEmail();
  }
}
