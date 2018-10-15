package 反射;

import 反射.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射动态操作：构造器 方法 属性
 */
public class Demo03 {
    public static void main(String[] args) {
        String path = "反射.bean.User";
        try {
            Class<User> aClass = (Class<User>) Class.forName(path);
            //通过反射api调用构造方法
            User user = aClass.newInstance(); //其实调用无参构造方法
            Constructor<User> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class);
            User user1 = declaredConstructor.newInstance("王宁", 1);
            System.out.println(user1.getName());

            //通过反射调用普通方法
            User user3 = aClass.newInstance(); //其实调用无参构造方法
            Method method = aClass.getDeclaredMethod("setName", String.class);
            method.invoke(user3, "帅哥");
            System.out.println(user3.getName());

            //通过反射操作属性
            User user4 = aClass.newInstance();
            Field field = aClass.getDeclaredField("name");
            //这个属性需要要安全检查，可以直接访问 可加快速度
            field.setAccessible(true);
            field.set(user4, "高山");//通过反射直接写属性
            System.out.println(user4.getName());
            System.out.println(field.get(user4)); //通过反射读属性

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
