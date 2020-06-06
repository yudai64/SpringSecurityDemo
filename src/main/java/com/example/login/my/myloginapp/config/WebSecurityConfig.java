package com.example.login.my.myloginapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http
          // AUTHORIZE
          .authorizeRequests()
                .mvcMatchers("/hello").permitAll()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .anyRequest().authenticated()
          .and()
          // LOGIN
          .formLogin()
                .loginPage("/showMyLoginPage")  //ログインのURL
                .loginProcessingUrl("/authenticateTheUser")  //
                .permitAll()
                .defaultSuccessUrl("/", true)
          .and()
          //LOGOUT
          .logout()
                .permitAll()
      // end
      ;
  }

  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

      auth
          .inMemoryAuthentication()
            .withUser("john").password("{noop}password").roles("EMPLOYEE")
            .and()
            .withUser("mary").password("{noop}password").roles("EMPLOYEE", "MANAGER")
            .and()
            .withUser("susan").password("{noop}password").roles("EMPLOYEE", "ADMIN");
  }
}