package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射api获取类的信息
 */
public class Demo02 {
    public static void main(String[] args) {
        String path = "反射.bean.User";
        try {
            Class<?> aClass = Class.forName(path);
            //获得全路径
            System.out.println(aClass.getName());
            //获取类型user
            System.out.println(aClass.getSimpleName());
            //获得public属性
            Field[] fields = aClass.getFields();
            //获得所有属性
            Field[] declaredFields = aClass.getDeclaredFields();
            //获得单个属性
            Field declaredField = aClass.getDeclaredField("name");
            for (Field field : declaredFields) {
                System.out.println("属性"+field);
            }
            Method[] methods = aClass.getMethods();
            Method getName1 = aClass.getDeclaredMethod("getName");
            // Method getName1 = aClass.getDeclaredMethod("getName",参数 String.class);
            System.out.println(getName1);
            for (Method method : methods) {
                System.out.println("方法"+method);
            }
            //获得所有的构造对象
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
