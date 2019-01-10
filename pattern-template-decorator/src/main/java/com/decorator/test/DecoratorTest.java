package com.decorator.test;

import com.decorator.ISigninForThirdService;
import com.decorator.ISigninForThirdServiceImpl;
import com.decorator.SiginServiceImpl;

/**
 * Created by Administrator on 2018/12/4 0004.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        ISigninForThirdService signinForThirdService = new ISigninForThirdServiceImpl(new SiginServiceImpl());
        signinForThirdService.loginQQ("11111111");

    }

}
