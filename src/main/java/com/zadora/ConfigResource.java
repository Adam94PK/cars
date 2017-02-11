package com.zadora;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by adam on 29.01.2017.
 */

@Configuration
@ComponentScan
public class ConfigResource extends WebMvcConfigurerAdapter{
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = new String[]{
            "classpath:/photos/",
            "classpath:/resources/",
            "classpath:/static/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        System.out.println("Resource mappint =======================================" +
                "RESOURCE MAPPING ==================================================" +
                "=====================================================================" +
                "=====================================================================");
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}
