package com.delegate2;

/**
 * Created by Administrator on 2018/11/29 0029.
 */
public class StaffB  implements IStaff {
    @Override
    public void doing(String command) {
        System.out.println("StaffB:"+command);
    }
}
