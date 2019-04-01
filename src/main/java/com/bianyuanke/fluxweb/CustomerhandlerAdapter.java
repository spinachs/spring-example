package com.bianyuanke.fluxweb;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author 马良
 * @since 2019-03-26
 */
@Component
public class CustomerhandlerAdapter extends RequestMappingHandlerAdapter {
    private MethodParameter parameter;

    {
        try {
            parameter = new MethodParameter(ResponseWrapper.class.getDeclaredMethod("methodParams"), -1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private Mono<ResponseEntiry> methodParams() {
        return null;
    }

    @Override
    public Mono<HandlerResult> handle(ServerWebExchange exchange, Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Api api = handlerMethod.getMethodAnnotation(Api.class);

        if (api != null) {
            Map<String, String> headers = exchange.getRequest().getHeaders().toSingleValueMap();

            if ("error".equals(headers.get("type"))) {
                ResponseEntiry entiry = new ResponseEntiry();
                entiry.setCode(-99);
                entiry.setMessage("这是一个错误");
                HandlerResult result = new HandlerResult(handler, entiry, parameter);

                return Mono.just(result);
            }
        }

        return super.handle(exchange, handler);
    }
}
