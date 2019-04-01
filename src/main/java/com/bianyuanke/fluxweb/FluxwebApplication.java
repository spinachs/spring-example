package com.bianyuanke.fluxweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;

@SpringBootApplication
public class FluxwebApplication {

    @Autowired
    ServerCodecConfigurer serverCodecConfigurer;
    @Autowired
    RequestedContentTypeResolver requestedContentTypeResolver;

    @Bean
    ResponseWrapper responseWrapper() {
        return new ResponseWrapper(serverCodecConfigurer
                .getWriters(), requestedContentTypeResolver);
    }

    public static void main(String[] args) {
        SpringApplication.run(FluxwebApplication.class, args);
    }

}
