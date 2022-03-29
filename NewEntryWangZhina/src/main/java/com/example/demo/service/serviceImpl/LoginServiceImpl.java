package com.example.demo.service.serviceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.EnUser;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;
import com.example.demo.utils.JWTUtils;
import com.example.demo.utils.Sha256Util;
import com.example.demo.vo.ErrorCode;
import com.example.demo.vo.LoginParam;
import com.example.demo.vo.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * @author wang_zhina
 * date 2022/3/27 15:22
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public Result login(LoginParam loginParam) {

        String username = loginParam.getUsername();
        String passwordFromParam = loginParam.getPassword();


        LambdaQueryWrapper<EnUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EnUser::getUsername,username);
        EnUser enUser = userMapper.selectOne(wrapper);
        if (!enUser.getPassword().equals(Sha256Util.getSHA256(passwordFromParam))){
            return Result.fail(ErrorCode.PASSWORD_ERROR.getCode(),ErrorCode.PASSWORD_ERROR.getMessage());
        }
        enUser.setNewTime(new Date());


        String token = JWTUtils.createToken(enUser.getId());
        System.out.println(token);
        redisTemplate.opsForValue().set(enUser.getId(),"Token"+token,1, TimeUnit.DAYS);
        return Result.success(ErrorCode.ADD_SUCCESS.getCode(), ErrorCode.SUCESS.getMessage(), token);
    }




}
