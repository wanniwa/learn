package 反射;

/**
 * 各种类型获得反射Class对象
 * 测试java.lang.Class
 */
public class Demo01 {
    public static void main(String[] args) {
        String path = "反射.bean.User";
        try {
            Class<?> aClass = Class.forName(path);
            System.out.println(aClass.hashCode());
            //一个类只对应一个反射对象
            Class<?> aClass1 = Class.forName(path);
            System.out.println(aClass1.hashCode());

            Class<String> aClass2 = String.class;
            Class<? extends String> aClass3 = path.getClass();
            System.out.println(aClass2==aClass3);
            Class<Integer> integerClass = int.class;

            int[] arr01 = new int[10];
            int[] arr02 = new int[30];
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
