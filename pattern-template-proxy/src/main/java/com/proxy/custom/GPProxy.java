package com.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/11/22 0022.
 */
public class GPProxy  {

        public static Object newProxyInstance(GPClassLoader classLoader,Class<?>[] interfaces,GPInvocationHandler h){
            try {
            //1.动态生成源代码.java文件
            String src = generateSrc(interfaces);


            //2.Java文件输出到磁盘
            String filePath = GPProxy.class.getResource("").getPath();
            System.out.println(filePath);
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();


            //3.把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);

            task.call();
            manager.close();

            //4.编译生成的.class文件加载到JVM中来
             Class proxyClass = classLoader.findClass("$Proxy0");
             Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            //5.返回字节码重组以后的新的代理对象
                f.delete();
             return c.newInstance(h);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.proxy.custom;" + "\r\n");
        sb.append("import com.proxy.dtdl.Person;" + "\r\n");
        sb.append("import java.lang.reflect.Method ;" + "\r\n");

        sb.append("public class $Proxy0 implements " + interfaces[0].getName() +"{"+"\r\n");

        sb.append("GPInvocationHandler h ;" + "\r\n");
                sb.append("public $Proxy0(GPInvocationHandler h){" + "\r\n");

                             sb.append("this.h = h ;" + "\r\n");

                sb.append("}" + "\r\n");

        for(Method m : interfaces[0].getMethods()) {
            sb.append("public " + m.getReturnType().getName() + "  " + m.getName() + "(){" + "\r\n");
            sb.append("try {" + "\r\n");
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + "\r\n");
            sb.append("this.h.invoke(this,m,null);" + "\r\n");
            sb.append(" }catch (Throwable e){" + "\r\n");
            sb.append("e.printStackTrace();            }" + "\r\n");
            sb.append("}" + "\r\n");

        }

        sb.append("}" + "\r\n");

        return sb.toString();
    }

}
