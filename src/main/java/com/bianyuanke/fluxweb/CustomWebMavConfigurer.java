package com.bianyuanke.fluxweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

/**
 * @author 马良
 * @since 2019-03-06
 */
@Configuration
public class CustomWebMavConfigurer implements WebFluxConfigurer {
    @Autowired
    private SelfArgumentResolvers selfArgumentResolvers;

    @Override
    public void configureArgumentResolvers(ArgumentResolverConfigurer configurer) {
        configurer.addCustomResolver(selfArgumentResolvers);
    }
}
