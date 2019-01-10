package com.oldadapter;

import com.oldadapter.passport.ResultMsg;

/**
 * Created by Administrator on 2018/12/3 0003.
 */
public class SiginService {

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    public ResultMsg register(String username,String password){

        return new ResultMsg("200","注册成功",username);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){


        return new ResultMsg("200","登录成功",username);
    }

}
