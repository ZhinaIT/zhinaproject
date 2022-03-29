package com.example.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @title: LoginParam
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author wang_zhina
 * date 2022/3/25 13:53
 */
@Data
public class LoginParam {
    @NotNull(message = "用户名不能为空")
    private String username;


    @NotNull(message = "密码不能为空")
    private String password;


}
