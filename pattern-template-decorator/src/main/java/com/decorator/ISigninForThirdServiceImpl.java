package com.decorator;

import com.oldadapter.passport.ResultMsg;

/**
 * Created by Administrator on 2018/12/4 0004.
 */
public class ISigninForThirdServiceImpl implements ISigninForThirdService {

   private SiginService siginService;

   public ISigninForThirdServiceImpl(SiginService siginService){
        this.siginService = siginService;
   }


    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResultMsg register(String username,String password){
        return siginService.register(username,password);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResultMsg login(String username,String password){
        return siginService.login(username, password);
    }

    public ResultMsg loginQQ(String openId){
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
        this.register(username, password);
        return this.login(username,password);
    }
}
