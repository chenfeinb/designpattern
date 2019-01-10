package com.observer.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/6 0006.
 */
public class EventLisenter {
    protected Map<Enum,Event> events = new HashMap<Enum, Event>();

    public void addLisenter(Enum eventType,Object target,Method callback){
        // 注册事件，用反射调用这个方法
        events.put(eventType,new Event(target,callback));
    }

    private void trigger(Event e){
        e.setSource(this);
        e.setTime(System.currentTimeMillis());

        try {
            e.getCallback().invoke(e.getTarget(),e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    protected void trigger(Enum call){
        if(!this.events.containsKey(call)){ return ;}
        trigger(this.events.get(call).setTrigger(call.toString()));
    }
}
