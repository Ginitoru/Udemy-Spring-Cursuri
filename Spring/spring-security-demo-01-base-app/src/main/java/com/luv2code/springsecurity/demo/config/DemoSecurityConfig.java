package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    //atentie aceasta clasa are mai multe metode dintre care am ales una pe care am suprascris-o PT A RETINE USERNAME SI PASS SI ROL
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("mary").password("test123").roles("MANAGER", "EMPLOYEE"))
                .withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));

    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .anyRequest().authenticated()    //orice request trebuie autentificat
//                .and()                           //si
//                    .formLogin()
//                    .loginPage("/showMyLoginPage")   //daca nu e il duce la login form
//                    .loginProcessingUrl("/authenticateTheUser")  //dupa care autentifica user
//                    .permitAll()   //permite la toti
//                .and()
//                .logout().permitAll(); //permit all pt logout
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER") // da acces la paginile /leaders si toate sub paginile /leaders doar pt rolul de MANAGER
                .antMatchers("/systems/**").hasRole("ADMIN")

                .and()                           //si
                .formLogin()
                .loginPage("/showMyLoginPage")   //daca nu e il duce la login form
                .loginProcessingUrl("/authenticateTheUser")  //dupa care autentifica user
                .permitAll()   //permite la toti
                    .and()
                    .logout().permitAll() //permit all pt logout
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied"); //ne duce spre pagina de acces-denied create de noi
    }
}
