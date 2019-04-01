package com.bianyuanke.fluxweb;

/**
 * @author 马良
 * @since 2019-03-11
 */
public class RequestException extends RuntimeException {
    private static final long serialVersionUID = 6679801236466313399L;
    private int code;
    private String message;

    public RequestException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
