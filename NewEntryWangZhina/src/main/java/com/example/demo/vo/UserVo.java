package com.example.demo.vo;


import lombok.Data;
import javax.validation.constraints.*;


@Data
public class UserVo {


    @NotNull(message = "姓名不能为空")
    private String username;
    @NotNull(message = "用户名不能为空")
    private String password;

    @NotNull(message = "手机号码不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号码必须为11位")
    private String phone;



    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;


}
