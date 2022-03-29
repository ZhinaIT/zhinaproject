package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.EnUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @title: UserMapper
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author wang_zhina
 * date 2022/3/25 15:32
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<EnUser> {

}
