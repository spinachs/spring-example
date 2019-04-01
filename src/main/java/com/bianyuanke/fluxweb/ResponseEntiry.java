package com.bianyuanke.fluxweb;

import lombok.Data;

/**
 * @author 马良
 * @since 2019-03-13
 */
@Data
public class ResponseEntiry {
    private int code;
    private String message;
    private Object body;
}
