package com.example.demo.service;

import com.example.demo.entity.EnUser;
import com.example.demo.vo.Result;
import com.example.demo.vo.UserVo;

/**
 * @title: UserService
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author Wang_Zhina
 * date 2022/3/28 17:52
 */
public interface UserService {

    Result save(UserVo userVo);

    EnUser findUser(String username, String password);

    Result updateStatus(String username);

    Result deleteById(String username);
}

