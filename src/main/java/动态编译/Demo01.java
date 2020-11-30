package 动态编译;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        // JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // int result = compiler.run(null, null, null, "E:\\gitWork\\learn\\src\\反射\\Demo03.java");
        // System.out.println(result==0?"编译成功":"编译失败");
        // Runtime runtime = Runtime.getRuntime();
        // Process process = runtime.exec("java -cp E:\\gitWork\\learn\\src\\反射 Demo03");
        // InputStream inputStream = process.getInputStream();
        // BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        // String info = "";
        // while ((info = reader.readLine()) != null) {
        //     System.out.println(info);
        // }

        try {
            URL[] urls = new URL[] {new URL("file:E:\\gitWork\\learn\\src\\")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("反射.Demo03");
            //调用加载类的main方法
            Method m = c.getMethod("main",String[].class);
            m.invoke(null, (Object)new String[]{});
            //由于可变参数是JDK5.0之后才有。
            //m.invoke(null, (Object)new String[]{});会编译成:m.invoke(null,"aa","bb"),就发生了参数个数不匹配的问题。
            //因此，必须要加上(Object)转型，避免这个问题。
            //public static void main(String[] args)
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
