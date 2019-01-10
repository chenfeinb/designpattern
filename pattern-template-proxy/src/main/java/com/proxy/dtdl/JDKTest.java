package com.proxy.dtdl;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
public class JDKTest {
    public static void main(String[] args) {
        try {
//            Person obj = (Person)new JDK58tc().getInstance(new Chenfei());
//            obj.findHouse();

           byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});

            FileOutputStream f = new FileOutputStream("$Proxy0.class");
            f.write(bytes);
            f.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
