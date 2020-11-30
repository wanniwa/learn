package 注解Annotation.自定义注解;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo03 {
    public static void main(String[] args) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("注解Annotation.自定义注解.Student");
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //获得类指定注解
            Table annotation = clazz.getAnnotation(Table.class);
            System.out.println(annotation.value());
            //获得类属性注解
            Field f = clazz.getDeclaredField("name");
            MyField annotation1 = f.getAnnotation(MyField.class);
            System.out.println(annotation1.columnName()+annotation1.type()+annotation1.length());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
