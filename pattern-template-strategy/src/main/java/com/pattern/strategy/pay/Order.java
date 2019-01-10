package com.pattern.strategy.pay;

import com.pattern.strategy.pay.payport.enums.PayType;

/**
 * Created by Administrator on 2018/11/26 0026.
 */
public class Order {
    private String uid;
    private String orderId;
    private double amout;

    public Order(String uid, String orderId, double amout) {
        this.uid = uid;
        this.orderId = orderId;
        this.amout = amout;
    }


//    public PayState pay(Payment payment){
//
//        return  payment.pay(uid,amout);
//    }

    public PayState pay(PayType payType){

        return  payType.get().pay(this.uid,this.amout);
    }
    //改动
}
