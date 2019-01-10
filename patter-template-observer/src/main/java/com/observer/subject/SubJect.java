package com.observer.subject;

import com.observer.core.EventLisenter;

/**
 * Created by Administrator on 2018/12/6 0006.
 */
public class SubJect  extends EventLisenter{

    //通常采用动态代理实现监控，避免代码侵入
    public void add(){
        System.out.println("调用一个添加的方法");
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("调用一个删除的方法");
        trigger(SubjectEventType.ON_RMOVE);
    }
}
