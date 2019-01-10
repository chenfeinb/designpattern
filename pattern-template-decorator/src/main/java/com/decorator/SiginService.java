package com.decorator;

import com.oldadapter.passport.ResultMsg;

/**
 * Created by Administrator on 2018/12/3 0003.
 */
public interface SiginService {

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    public ResultMsg register(String username,String password);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password);

}
