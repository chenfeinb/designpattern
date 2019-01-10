package com.proxy.cglib;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
public class CgLibTest {

    public static void main(String[] args) {
        try {
            Zhangsan obj = (Zhangsan)new CGlibMeipo().getInstance(Zhangsan.class);
            obj.findLove();
            System.out.println(obj.getClass());
            // class com.proxy.cglib.Zhangsan$$EnhancerByCGLIB$$f98917be
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
