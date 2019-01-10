package com.proxy.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/11/22 0022.
 */
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}
