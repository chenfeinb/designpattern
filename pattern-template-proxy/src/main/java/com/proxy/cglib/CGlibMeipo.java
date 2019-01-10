package com.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
public class CGlibMeipo implements MethodInterceptor{

    public Object getInstance(Class<?> clazz) throws Exception {

        Enhancer enhancer = new  Enhancer();

        //要把哪一个设置为即将生成的新的父类
        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 业务的增强
        methodProxy.invokeSuper(o,objects);
        System.out.println("媒婆开始工作");

        return null;
    }
}
