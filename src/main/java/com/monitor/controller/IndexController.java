package com.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @GetMapping(path = {"/home", "/"})
  public String index(Model m){
    m.addAttribute("pageTitle", "Home Page");
    m.addAttribute("pageBody", "Hello, world!");
    return "index";
  }
}
