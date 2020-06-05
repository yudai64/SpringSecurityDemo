package com.example.login.my.myloginapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class DemoController {
  private static Log log = LogFactory.getLog(DemoController.class);

   @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/success")
    public String success() {
      log.info("success通過");
        return "success";
    }

}
