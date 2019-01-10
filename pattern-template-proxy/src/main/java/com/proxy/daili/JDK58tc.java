package com.proxy.daili;

import com.proxy.dtdl.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
public class JDK58tc implements InvocationHandler {
    private Person target;

    public Object getInstance(Person target) throws Exception{
        this.target = target;

        Class<?> clazz = target.getClass();
        // 字节码重复来实现
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是58：开始找房子");

        method.invoke(this.target,args);


        return null;
    }
}
