package com.delegate2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/29 0029.
 */
public class Leader implements IStaff{

    private Map<String,IStaff>  map = new HashMap<String, IStaff>();

    public Leader() {
        map.put("加密",new StaffA());
        map.put("登录",new StaffB());
    }

    @Override
    public void doing(String command) {
        map.get(command).doing(command);
    }
}
