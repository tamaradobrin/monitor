package com.monitor.controller;

import com.monitor.model.User;
import com.monitor.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  private UserService userService;

  public IndexController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(path = {"/home", "/"})
  public String index(Model m){
    User user = userService.getUserByUserName("tami");
    m.addAttribute("pageTitle", "Home Page");
    m.addAttribute("pageBody", "Hello, world!");
    return "index";
  }
}
