package com.example.demo.service;

import com.example.demo.vo.LoginParam;
import com.example.demo.vo.Result;

/**
 * @title: LoginService
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author wang_zhina
 * date 2022/3/27 15:22
 */
public interface LoginService {
    Result login(LoginParam loginParam);
}
