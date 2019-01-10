package com.proxy.daili;

import com.proxy.dtdl.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
public class JDKMeipo implements InvocationHandler {
    private Person target;

    public Object getInstance(Person target) throws Exception{
        this.target = target;

        Class<?> clazz = target.getClass();
        // 字节码重复来实现
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：开始找对象");
        System.out.println("我是媒婆：开始找");

        method.invoke(this.target,args);


        return null;
    }
}
