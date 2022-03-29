package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.EnUser;
import com.example.demo.service.UserService;
import com.example.demo.utils.Sha256Util;
import com.example.demo.vo.ErrorCode;
import com.example.demo.vo.Result;
import com.example.demo.vo.UserVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @title: UserServiceImpl
 * @projectName NewEntryWangZhina
 * @description: TODO
 * @author wang_zhina
 * @date  2022/3/25 14:49
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public Result save(UserVo userVo) {
        /**
          *判断参数是否合法
          */
        String username = userVo.getUsername();
        String email = userVo.getEmail();
        String phone = userVo.getPhone();
        String password = userVo.getPassword();

        EnUser userByUsername = findUserByUsername(username);
        if (userByUsername !=null){
            return Result.fail(ErrorCode.SAVE_FAIL.getCode(),ErrorCode.SAVE_FAIL.getMessage());
        }
        EnUser userByPhone = findUserByPhone(phone);
        if (userByPhone !=null){
            return Result.fail(ErrorCode.SAVE_PHONE_FAIL.getCode(), ErrorCode.SAVE_PHONE_FAIL.getMessage());
        }
        String sha256password = Sha256Util.getSHA256(password);
        EnUser enUser = new EnUser();
        enUser.setUsername(username);
        enUser.setPhone(phone);
        enUser.setEmail(email);
        enUser.setPassword(sha256password);
        enUser.setStatus(1);
        enUser.setIsDelete(1);
        enUser.setCreateTime(new Date());
        enUser.setNewTime(new Date());
        enUser.setDelTime(null);
        System.out.println(enUser);
        System.out.println(userMapper.insert(enUser));

        return Result.success(ErrorCode.ADD_SUCCESS.getCode(), ErrorCode.SUCESS.getMessage(),"添加成功");
    }


    @Override
    public EnUser findUser(String username, String password) {
        LambdaQueryWrapper<EnUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EnUser::getUsername,username);
        wrapper.eq(EnUser::getPassword,password);
        wrapper.last("limit 1");
        return userMapper.selectOne(wrapper);
    }

    @Override
    public Result updateStatus(String username) {
        LambdaQueryWrapper<EnUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EnUser::getUsername,username);
        EnUser enUser = userMapper.selectOne(wrapper);
        System.out.println(enUser.getId());
        EnUser enUser1 = new EnUser();

        enUser1.setNewTime(new Date());
        enUser1.setId(enUser.getId());
        enUser1.setStatus(2);
        int i = userMapper.updateById(enUser1);

        return Result.success(ErrorCode.BAN_STATUS.getCode(), ErrorCode.BAN_STATUS.getMessage(),"用户的状态已经变更为禁用");
    }

    @Override
    public Result deleteById(String username) {
        if (username == null){
            return Result.fail(ErrorCode.ID_ERROR.getCode(),ErrorCode.ID_ERROR.getMessage());
        }
        LambdaQueryWrapper<EnUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EnUser::getUsername,username);
        EnUser enUser = userMapper.selectOne(wrapper);

        System.out.println(enUser.getUsername());
        EnUser enUser1 = new EnUser();
        enUser1.setId(enUser.getId());
        enUser1.setDelTime(new Date());
        enUser1.setIsDelete(2);
        userMapper.updateById(enUser1);

        return Result.success(ErrorCode.DEL_SUCCESS.getCode(), ErrorCode.DEL_SUCCESS.getMessage(),"删除成功");
    }

    //根据手机号
    private EnUser findUserByPhone(String phone) {
        LambdaQueryWrapper<EnUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EnUser::getPhone,phone);
        wrapper.last("limit 1");
        return userMapper.selectOne(wrapper);
    }

    public EnUser findUserByUsername(String username){
        LambdaQueryWrapper<EnUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EnUser::getUsername,username);
        wrapper.last("limit 1");
        return userMapper.selectOne(wrapper);
    }





}
