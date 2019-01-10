package com.proxy.custom;

import com.proxy.dtdl.Chenfei;
import com.proxy.dtdl.Person;

/**
 * Created by Administrator on 2018/11/22 0022.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Person obj = (Person)new GPMeipo().getInstance(new Chenfei());
            obj.findLove();

//            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
//
//            FileOutputStream f = new FileOutputStream("$Proxy0.class");
//            f.write(bytes);
//            f.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
