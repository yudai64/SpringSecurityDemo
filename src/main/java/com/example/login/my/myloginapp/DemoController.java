package com.example.login.my.myloginapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
  
  @GetMapping("hello")
  public String hello() {
    return "hello";
  }

  @GetMapping( "success")
  public String success() {
    return "success";
  }

  @GetMapping("/page1")
  public String page1() {
    return "page1";
  }
}