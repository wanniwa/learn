package 手写服务器.反射;

/**
 * 获取结构信息
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        String str = "abc";
        //对象.getClass()
        Class<?> aClass = str.getClass();
        //类.class
        aClass = String.class;
        //完整路径 Class.forName(路径)
        aClass = Class.forName("java.lang,String");
    }
}
