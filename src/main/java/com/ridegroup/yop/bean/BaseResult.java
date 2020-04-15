package com.ridegroup.yop.bean;

/**
 * YOP请求状态数据
 *
 * @author PeterZhang
 */
public class BaseResult {
    private static final String SUCCESS_CODE = "200";

    private String code;
    private String msg;

    public BaseResult() {
    }

    public BaseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return code == null || code.isEmpty() || code.equals(SUCCESS_CODE);
    }

}
