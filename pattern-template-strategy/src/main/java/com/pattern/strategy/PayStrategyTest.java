package com.pattern.strategy;

import com.pattern.strategy.pay.Order;
import com.pattern.strategy.pay.payport.enums.PayType;

/**
 * Created by Administrator on 2018/11/26 0026.
 */
public class PayStrategyTest {
    public static void main(String[] args) {

        // 把商品添加到购物车 再从购物车下单
        // 直接从点单开始了这个
        Order order = new Order("1","201800001",324.45);

        // 支付宝，微信，银行卡，信用卡
//        System.out.println(order.pay(Payment.WE_CHAT_PAY));

        System.out.println(order.pay(PayType.ALI_PAY));
    }
}
