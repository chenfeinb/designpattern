package com.adapter;

import com.adapter.passport.ResultMsg;

/**
 * 继承，非常稳定的方法不去动，直接继承
 * Created by Administrator on 2018/12/3 0003.
 */
public class SiginforThirdService extends SiginService {

    public ResultMsg loginQQ(String openId){

        // 1.openId全局唯一，把他当做用户名

        // 2.密码默认为123456

        // 3.注册（在原有的系统创建一个用户）

        // 4.调用原来的登录方法

        return loginRegister(openId,"123456");
    }

    public ResultMsg loginWechat(String openId){

        return null;
    }

    public ResultMsg loginToken(String Token){
        return null;
    }

    public ResultMsg loginTelephone(String telephone ,String code){
        return null;

    }

    public ResultMsg loginRegister(String username,String password){
        super.register(username,password);
        return super.login(username,password);
    }
}
