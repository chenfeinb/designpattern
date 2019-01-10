package com.proxy.dtdl;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
public class Chenfei implements Person{
    public void findLove(){
        System.out.println("本人要求：肤白貌美，白富美");
    }

    @Override
    public void findHouse() {
        System.out.println("本人要求：三居室");
    }
}
