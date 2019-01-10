package com.decorator;

import com.oldadapter.passport.ResultMsg;

/**
 * Created by Administrator on 2018/12/4 0004.
 */
public interface ISigninForThirdService extends SiginService{

    public ResultMsg loginQQ(String openId);

    public ResultMsg loginWechat(String openId);

    public ResultMsg loginToken(String Token);

    public ResultMsg loginTelephone(String telephone ,String code);

    public ResultMsg loginRegister(String username,String password);



}
