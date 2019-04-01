package com.bianyuanke.fluxweb;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author 马良
 * @since 2019-03-11
 */
@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(Exception.class)
    public ResponseEntiry serverExceptionHanlder(ServerWebExchange exchange, Exception ex) {
        ResponseEntiry entiry;
        if (ex instanceof WebExchangeBindException) {
            entiry = handleValidationException((WebExchangeBindException) ex);
        } else if (ex instanceof RequestException) {
            entiry = handleRequestException((RequestException) ex);
        } else {
            entiry = new ResponseEntiry();
            entiry.setCode(-1);
            entiry.setMessage(ex.getMessage());
        }

        return entiry;
    }

    private ResponseEntiry handleRequestException(RequestException ex) {
        ResponseEntiry entiry = new ResponseEntiry();
        entiry.setCode(ex.getCode());
        entiry.setMessage(ex.getMessage());

        return entiry;
    }

    private ResponseEntiry handleValidationException(WebExchangeBindException ex) {
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();

        ResponseEntiry entiry = new ResponseEntiry();
        entiry.setCode(-2);
        entiry.setMessage(message);
        return entiry;
    }

//    @ExceptionHandler(RequestException.class)
//    public String requestExceptionHanlder(ServerHttpRequest req, RequestException ex) throws JsonProcessingException {
//        System.out.println(req.getPath());
//        Map<String, Object> result = new HashMap<>();
//        result.put("code", 200);
//        result.put("msg", ex.getMessage());
//        result.put("cmd", req.getURI().getPath());
//        return new ObjectMapper().writeValueAsString(result);
//    }

}
