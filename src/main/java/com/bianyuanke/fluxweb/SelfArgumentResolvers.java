package com.bianyuanke.fluxweb;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 马良
 * @since 2019-03-12
 */
@Component
public class SelfArgumentResolvers implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return true;
    }

    @Override
    public Mono<Object> resolveArgument(MethodParameter parameter, BindingContext bindingContext, ServerWebExchange exchange) {
        Class<?> clazz = parameter.getParameterType();
        if (clazz.isAssignableFrom(String.class)) {
            return Mono.just("xyz");
        }
        return null;
    }
}
