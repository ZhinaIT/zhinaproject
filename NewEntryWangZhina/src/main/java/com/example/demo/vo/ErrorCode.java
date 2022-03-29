package com.example.demo.vo;

/**
  *@description:TODO
  *param 
  @return 
  *@throws
  *@author wang_zhina
  @date 2022/3/27 16:14
  */

public enum ErrorCode {


    SUCESS("200", "请求成功"),
    ACCOUT_PWD_NOT_EXIT("1002","用户名或密码不存在"),
    BAN_STATUS("1003","禁用成功"),
    LOGIN_SUCESS("2001","登录成功"),

    PARAM_ERROR("1001", "请求参数有误!"),
    SAVE_FAIL("500", "该用户名已经被注册"),
    SAVE_PHONE_FAIL("5001","手机号已经被注册"),
    ADD_SUCCESS("200", "新增成功"),
    DEL_SUCCESS("200", "删除成功"),
    ID_ERROR("300","ID不存在"),
    PASSWORD_ERROR("800","密码错误");


    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
