package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.vo.Result;
import com.example.demo.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @title: UserController
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author Wang_Zhina
 * date 2022/3/28 17:49
 */
@RestController
@RequestMapping("user")
public class UserController {
        @Autowired
        private UserService userService;

        @ApiOperation(value = "新增用户")
        @PostMapping("/save")
        public Result save(@RequestBody @Validated UserVo userVo){
            return userService.save(userVo);
        }

        @PostMapping("/updateStatus/{username}")
        @ApiOperation(value = "禁用用户信息")
        public Result updateStatus(@PathVariable String username){
            return userService.updateStatus(username);
        }

        @DeleteMapping("/delete")
        @ApiOperation(value = "删除用户信息")
        public Result deleteById(@RequestBody String username){
            return userService.deleteById(username);
        }



    }


