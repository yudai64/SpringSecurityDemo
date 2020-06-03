package com.example.login.my.myloginapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http
          // AUTHORIZE
          .authorizeRequests()
          /* */.mvcMatchers("/hello").permitAll()
          /* */.anyRequest()
          /*    */.authenticated()
          .and()
          // LOGIN
          .formLogin()
          // /* */.loginPage("/login")
          // /*    */.permitAll()
          /* */.defaultSuccessUrl("/success", true)
      // end
      ;
  }

  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

      auth
          .inMemoryAuthentication()
            .withUser("user").password("{noop}password").roles("USER");
  }
}