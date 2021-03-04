package com.ems.domain.model;

import java.io.Serializable;

/**
 * @author dyf
 */
public class CommonResponseForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean flag;

    private Object data;

    private String msg;

    public CommonResponseForm(boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public CommonResponseForm() {
    }

    public CommonResponseForm(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public static CommonResponseForm success(String msg, Object data) {
        return new CommonResponseForm(true, data, msg);
    }

    public static CommonResponseForm success(String msg) {
        return new CommonResponseForm(true, msg);
    }

    public static CommonResponseForm error(String msg) {
        return new CommonResponseForm(false, msg);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
