package com.luv2code.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan("com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties") //citeste fisierul din resources care contine referintele la baza de date
public class DemoAppConfig {

    private Logger logger = Logger.getLogger(getClass().getName());


    @Autowired
    private Environment env;  //contine valorile bazei de date care sunt citite din fisierul din resources


    //definire beean pt view resolver

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //security data source
    @Bean
    public DataSource securityDataSource(){

        //create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        //set jdbc driver
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver")); //citeste proprietatea de driver din env
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        //log conexiune si proprietati ca sa ne asiguram ca citim ce trebuie si de unde trebuie
        logger.info(">> jdbc.url = " + env.getProperty("jdbc.url"));
        logger.info("jdbc.user = " + env.getProperty("jdbc.user"));

        //setare conexiune baza de date

        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));


        return securityDataSource;
    }


    private int getIntProperty(String propName){
        String propVal = env.getProperty(propName);

        int intPropVal = Integer.parseInt(propVal); //trebuie sa returnam valoarea din fisierul de proprietati cicita caint si nu String
        return intPropVal;
    }











}
