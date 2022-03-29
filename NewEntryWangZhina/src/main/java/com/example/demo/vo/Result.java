package com.example.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: Result
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author Wang_Zhina
 * date 2022/3/28 17:33
 */

@Data
@AllArgsConstructor //构造方法
@NoArgsConstructor
public class Result {
    @ApiModelProperty(value = "返回码")
    private String code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Object data;

    public static Result success(String code,String message,Object data){
        return new Result(code,message,data);
    }

    public static Result fail(String code, String message){
        return new Result(code,message,null);

    }
    public static Result error(String message) {
        return new Result(null, message, "");
    }
}
