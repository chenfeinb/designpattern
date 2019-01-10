package com.delegate2;

/**
 * Created by Administrator on 2018/11/29 0029.
 */
public class StaffA implements IStaff {
    @Override
    public void doing(String command) {
        System.out.println("StaffA:"+command);
    }
}
