package com.ply.flashsalessystem.config;

import com.ply.flashsalessystem.filter.LoginFile;
import com.ply.flashsalessystem.filter.UserFilter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<UserFilter> UserFilterOneRegister() {
        FilterRegistrationBean<UserFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new UserFilter());
        filterRegistrationBean.addUrlPatterns("/user/*");
        filterRegistrationBean.addUrlPatterns("/store/*");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<LoginFile> LoginFilterOneRegister() {
        FilterRegistrationBean<LoginFile> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFile());
        filterRegistrationBean.addUrlPatterns("/login/*");
        return filterRegistrationBean;
    }
}