package com.proxy.custom;
import com.proxy.dtdl.Person;
import java.lang.reflect.Method ;
public class $Proxy0 implements com.proxy.dtdl.Person{
GPInvocationHandler h ;
public $Proxy0(GPInvocationHandler h){
this.h = h ;
}
public void  findHouse(){
try {
Method m = com.proxy.dtdl.Person.class.getMethod("findHouse",new Class[]{});
this.h.invoke(this,m,null);
 }catch (Throwable e){
e.printStackTrace();            }
}
public void  findLove(){
try {
Method m = com.proxy.dtdl.Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,m,null);
 }catch (Throwable e){
e.printStackTrace();            }
}
}
