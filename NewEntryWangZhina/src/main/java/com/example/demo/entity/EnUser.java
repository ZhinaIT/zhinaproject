package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @title: enUser1
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author Wang_Zhina
 * date 2022/3/28 17:26
 */
@Data
@TableName("en_user")
public class EnUser {


    /**
     *param id
     * 默认id类型就是雪花算法
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value ="电话号码" )
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "最近更新时间")
    private Date newTime;

    @ApiModelProperty(value = "删除时间")
    private Date delTime;

    @ApiModelProperty(value = "是否软删除用户")
    private Integer isDelete;



}
