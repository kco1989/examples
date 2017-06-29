package com.kco.springmvc.exception;

/**
 * Created by Administrator on 2017/6/29.
 */
public class AppBaseException extends RuntimeException{
    public AppBaseException() {
        super();
    }

    public AppBaseException(String message) {
        super(message);
    }

    public AppBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppBaseException(Throwable cause) {
        super(cause);
    }

    protected AppBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
