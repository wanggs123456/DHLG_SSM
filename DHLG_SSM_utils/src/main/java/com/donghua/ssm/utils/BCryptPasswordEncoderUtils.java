package com.donghua.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    public static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="916525";
        String pwd = encodePassword(password);
        //$2a$10$tJHudmJh6MRPdiL7mv0yfe0nZJbDHuhl7sSTnqNC4DauMik9ppi4K
        //$2a$10$Ce8LB3jdYDZ2f6HB281zA.4eC7v6ziJdK8MMWg0Yu8ETMg5ToMpIe

        //之前的都是没加密的密码 现在都是用了加密的 所以之前手动输入的未加密的密码对应的user无法登录，
        //所以需要用这个BCryptPasswordEncoderUtils类先得到密码的加密样式输入到数据库 之后才能登陆
        System.out.print(pwd);
    }
}
