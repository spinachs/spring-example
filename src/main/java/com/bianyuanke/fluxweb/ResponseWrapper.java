package com.bianyuanke.fluxweb;

import org.springframework.core.MethodParameter;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author 马良
 * @since 2019-03-22
 */
public class ResponseWrapper extends ResponseBodyResultHandler {
    private MethodParameter parameter;

    {
        try {
            parameter = new MethodParameter(ResponseWrapper.class.getDeclaredMethod("methodParams"), -1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public ResponseWrapper(List<HttpMessageWriter<?>> writers, RequestedContentTypeResolver resolver) {
        super(writers, resolver);
    }

    private Mono<ResponseEntiry> methodParams() {
        return null;
    }


    @Override
    public boolean supports(HandlerResult result) {
        return true;
    }

    @Override
    public Mono<Void> handleResult(ServerWebExchange exchange, HandlerResult result) {
        Object returnValue = result.getReturnValue();
        if (result.getReturnValue() == null) {
            return writeBody(Mono.just(new ResponseEntiry()), parameter, exchange);
        } else if (returnValue instanceof ResponseEntiry) {
            return writeBody(Mono.just(returnValue), parameter, exchange);
        } else if (returnValue instanceof Mono) {
            Mono<ResponseEntiry> entiryMono = ((Mono) result.getReturnValue())
                    .map(item -> {
                        ResponseEntiry entiry = new ResponseEntiry();
                        entiry.setBody(item);
                        return entiry;
                    });
            return writeBody(entiryMono, parameter, exchange);
        } else {
            ResponseEntiry entiry = new ResponseEntiry();
            entiry.setBody(returnValue);

            return writeBody(Mono.just(entiry), parameter, exchange);
        }
    }
}
