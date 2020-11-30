package 测试脚本引擎;

import javax.annotation.processing.Filer;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException, URISyntaxException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        engine.put("msg", "wanniwa is good man");
        String str = "var user = {name:'wanniwa',age:18,schools:['清华大学','南京大学']};";
        str += "print(user.name)";

        engine.eval(str);
        engine.eval("msg = 'sxt is a  goood man';");
        System.out.println(engine.get("msg"));
        System.out.println("##############################");


        //定义函数
        engine.eval("function add(a,b){var sum = a+ b; return sum}");
        //执行js函数
        Invocable jsInvoke = (Invocable) engine;
        //执行脚本中定义的方法
        Object result = jsInvoke.invokeFunction("add", new Object[]{13, 20});
        System.out.println(result);

        //导入其他java包 使用其他包中的java类
        // jdk1.6
        // String jsCode = "importPackage(java.util);" +
        //         "var list = Arrays.asList(['北京','大学'])";

        //jdk1.8  Rhino
        String jsCode = "var list =  java.util.Arrays.asList(['北京','大学'])";
        engine.eval(jsCode);

        List<String> list =(List<String>) engine.get("list");
        for (String s : list) {
            System.out.println(s);
        }


        //执行一个js文件
        URL url = Demo01.class.getClassLoader().getResource("测试脚本引擎/a.js");
        //tourI解决路径中包含中文
        FileReader fileReader = new FileReader(url.toURI().getPath());
        engine.eval(fileReader);
        fileReader.close();



    }
}
