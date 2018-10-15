package 反射;

import 反射.bean.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author dell
 *
 */
public class Demo04 {
	
	public void test01(Map<String, User> map, List<User> list){
		System.out.println("Demo04.test01()");
	}
	
	public Map<Integer,User> test02(){
		System.out.println("Demo04.test02()");
		return null;
	}
	
	public static void main(String[] args) {

		try {
			
			//���ָ����������������Ϣ
			Method m = Demo04.class.getMethod("test01", Map.class,List.class);
			Type[] t = m.getGenericParameterTypes();
			for (Type paramType : t) {
				System.out.println("#"+paramType);
				if(paramType instanceof ParameterizedType){
					Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
					for (Type genericType : genericTypes) {
						System.out.println("参数类型为"+genericType);
					}
				}
			}
			
			Method m2 = Demo04.class.getMethod("test02", null);
			Type returnType = m2.getGenericReturnType();
			if(returnType instanceof ParameterizedType){
					Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();

					for (Type genericType : genericTypes) {
						System.out.println("返回类型"+genericType);
					}
					
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	
	}
}
