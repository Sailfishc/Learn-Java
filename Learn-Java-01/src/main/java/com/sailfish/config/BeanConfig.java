package com.sailfish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author sailfish
 * @create 2017-03-08-上午9:15
 */
@Configuration
public class BeanConfig {


    @Bean
    public javax.validation.Validator getValidator() {
        return new LocalValidatorFactoryBean();
    }
}
