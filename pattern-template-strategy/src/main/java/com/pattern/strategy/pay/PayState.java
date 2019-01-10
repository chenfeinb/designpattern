package com.pattern.strategy.pay;

/**
 * Created by Administrator on 2018/11/26 0026.
 */
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "支付状态{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
