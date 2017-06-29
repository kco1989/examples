package com.kco.springmvc.bean;

import com.kco.springmvc.exception.AppBaseException;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/19.
 */
public class ResponseBean {
    private String message;
    private boolean success;
    private Object data;
    private int count;

    public ResponseBean(Object e, boolean success){
        this(e);
        setSuccess(success);
    }

    public ResponseBean(Object e, int count){
        this(e);
        setCount(count);
    }

    public ResponseBean(Object obj){
        if(obj == null){
            setSuccess(true);
        }else if(obj instanceof String){
            setMessage(obj.toString());
            setSuccess(false);
        }else if(obj instanceof Collection){
            setData(obj);
            setCount(((Collection) obj).size());
            setSuccess(true);
        }else if(obj instanceof Map){
            setData(obj);
            setCount(((Map) obj).size());
            setSuccess(true);
        }else if(obj instanceof Throwable){
            if (obj instanceof AppBaseException){
                setMessage(((AppBaseException) obj).getMessage());
            }else{
                setMessage("服务器异常.");
            }
            setSuccess(false);
        }else{
            setData(obj);
            setCount(1);
            setSuccess(true);
        }
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
