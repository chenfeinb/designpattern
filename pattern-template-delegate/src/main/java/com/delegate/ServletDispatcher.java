package com.delegate;

import com.delegate.controllers.MemberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目经理的角色
 * Created by Administrator on 2018/11/29 0029.
 */
public class ServletDispatcher {

    private List<Handler> handlerMapping = new ArrayList<Handler>();

    public  ServletDispatcher(){

        Class<?> memberClass = MemberAction.class;
        try {
                handlerMapping.add(new Handler().
                        setController(memberClass.newInstance()).
                        setMethod(memberClass.getMethod("getMemberById",new Class[]{String.class})).
                        setUrl("/web/getMemberById.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void doService(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        doDispatcher(httpServletRequest, httpServletResponse);
    }

    private void doDispatcher(HttpServletRequest request,HttpServletResponse response)   {

        //1.获取用户的请求url

        String uri = request.getRequestURI();
        //2.Servlet拿到url要做权衡（做选择），
        // 根据用户的请求url找到url对应的java类方法

        //3.通过拿到的URL找handlerMapping（策略常量）

        Handler handler = null;
        for(Handler h : handlerMapping){
            if(uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }

        //4.将具体的任务分发给Method （通过反射区调用其对应方法）
        Object obj = null;
        try {
            obj = handler.getMethod().invoke(handler.getController(),request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //5.获取到Method执行的结果，通过Response返回出去
        try {
            response.getWriter().write(obj.toString());
        } catch (IOException e) {
        }


    }


    class  Handler{
        private Object controller;
        private Method method;
        private  String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

}
