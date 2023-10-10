package org.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//We need to config the IOC container (Tell Spring framework try to config this package)
@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

}
