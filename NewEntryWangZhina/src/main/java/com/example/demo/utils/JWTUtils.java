package com.example.demo.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @title: JWTUtils
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author wang_zhina
 * date 2022/3/27 15:26
 */
public class JWTUtils {
    //定义的密钥
    private static final String jwtToken = "zhina_1022";

    public static String createToken(String userId){
        //装B的部分
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,jwtToken) //签发算法，密钥为token
                .setClaims(map) //body 数据要唯一，自行设置
                .setIssuedAt(new Date()) //设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*60*1000));//这是一天有效时间
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String,Object> checkToken(String token) {
        try {
            //解析token（要提供密钥）
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            //拿到userid,然后返回
            return (Map<String,Object>) parse.getBody();

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;

    }
    //yanzhang
  /*  public static void main(String[] args) {
        String tokem = JWTUtils.createToken("100");
        System.out.println(tokem);
        final Map<String, Object> map = JWTUtils.checkToken(tokem);
        System.out.println(map.get("userId"));
    }*/

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }
}
