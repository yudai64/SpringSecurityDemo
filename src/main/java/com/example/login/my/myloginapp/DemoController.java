package com.example.login.my.myloginapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoController {
  private static Log log = LogFactory.getLog(DemoController.class);

   @GetMapping(path = "hello", produces = "text/html")
    public String hello() {
        return "Hello!!!";
    }

    @GetMapping(path = "success", produces = "text/html")
    public String success() {
      log.info("success通過");
        return "成功!!!";
    }

    @GetMapping(path = "page1", produces = "text/html")
    public String page1() {
      log.info("ページ1通過");
        return "ページ１";
    }
}
