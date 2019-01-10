package com.pattern.strategy.pay.payport;

import com.pattern.strategy.pay.PayState;

/**
 * Created by Administrator on 2018/11/26 0026.
 */
public interface Payment {

    // 问题 每次增加渠道 都要去维护 麻烦麻烦麻烦麻烦麻烦麻烦麻烦麻烦  来个枚举类
//    public final static Payment ALI_PAY = new AliPay();
//    public final static Payment WE_CHAT_PAY = new WechatPay();


    public PayState pay(String uid,double amount);
}
