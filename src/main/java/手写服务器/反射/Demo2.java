package 手写服务器.反射;

import 手写服务器.demo3.Servlet;

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("手写服务器.demo1.Servlet");
        Servlet servlet = (Servlet) aClass.newInstance();


    }
}
