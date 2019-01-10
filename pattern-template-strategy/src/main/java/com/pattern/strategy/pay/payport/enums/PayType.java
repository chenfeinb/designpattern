package com.pattern.strategy.pay.payport.enums;

import com.pattern.strategy.pay.payport.Payment;
import com.pattern.strategy.pay.payport.pay.AliPay;
import com.pattern.strategy.pay.payport.pay.WechatPay;

/**
 * 就是一个支付常量池
 */
public enum  PayType {
    ALI_PAY(new AliPay()),WECHAT_PAY(new WechatPay());

    private Payment payment;
    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get(){
        return this.payment;
    }
}
