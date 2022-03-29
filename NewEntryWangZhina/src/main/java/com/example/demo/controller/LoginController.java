package com.example.demo.controller;

import com.example.demo.service.LoginService;
import com.example.demo.vo.LoginParam;
import com.example.demo.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: LoginController
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author Wang_Zhina
 * date 2022/3/28 17:51
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "用户登陆")
    @PostMapping
    public Result login(@Validated @RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }

}
