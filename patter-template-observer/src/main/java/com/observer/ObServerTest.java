package com.observer;

import com.observer.core.Event;
import com.observer.subject.ObServer;
import com.observer.subject.SubJect;
import com.observer.subject.SubjectEventType;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/12/6 0006.
 */
public class ObServerTest {

    public static void main(String[] args) {

        ObServer obServer = new ObServer();
        try {

            Method advice = ObServer.class.getMethod("advice", new Class[]{Event.class});


            SubJect subJect = new SubJect();

            subJect.addLisenter(SubjectEventType.ON_ADD, obServer, advice);

            subJect.addLisenter(SubjectEventType.ON_RMOVE, obServer, advice);


            subJect.add();
            subJect.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
