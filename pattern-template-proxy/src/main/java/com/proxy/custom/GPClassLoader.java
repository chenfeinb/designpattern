package com.proxy.custom;

import java.io.*;

/**
 * Created by Administrator on 2018/11/22 0022.
 */
public class GPClassLoader extends ClassLoader {

    private File classPathFile;

    public GPClassLoader(){
        String classPath = GPClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String className = GPClassLoader.class.getPackage().getName() + "."+ name;

        if(classPathFile != null){
            File classFile = new File(classPathFile,name.replaceAll("\\.","/") + ".class");
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out =null;

                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte [] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1 ){
                        out.write(buff,0,len);
                    }
                    return  defineClass(className,out.toByteArray(),0,out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(in != null){
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        if(out != null){
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return null;

    }
}
