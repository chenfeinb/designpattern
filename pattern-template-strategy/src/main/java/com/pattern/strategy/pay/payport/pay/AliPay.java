package com.pattern.strategy.pay.payport.pay;

import com.pattern.strategy.pay.PayState;
import com.pattern.strategy.pay.payport.Payment;

/**
 * Created by Administrator on 2018/11/26 0026.
 */
public class AliPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用支付宝");
        System.out.println("支付完成");
        return new PayState(200,"支付成功",amount);
    }
}
