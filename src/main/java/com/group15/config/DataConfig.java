package com.group15.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


import javax.sql.DataSource;

@Configuration
@PropertySource("application.properties")
public class DataConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setConfigLocation(config);
        sessionFactory.setPackagesToScan(
                env.getProperty("quizapp.entity.package1"),
                env.getProperty("quizapp.entity.package2"),
                env.getProperty("quizapp.entity.package3"),
                env.getProperty("quizapp.entity.package4")
        );
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
       BasicDataSource ds = new BasicDataSource();
        // set the driver class name
        ds.setDriverClassName(env.getProperty("quizapp.db.driver"));
        // set url
        ds.setUrl(env.getProperty("quizapp.db.url"));
        // set username
        ds.setUsername(env.getProperty("quizapp.db.username"));
        // set password
        ds.setPassword(env.getProperty("quizapp.db.password"));


       return ds;
    }
}
