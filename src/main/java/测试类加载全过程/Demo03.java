package 测试类加载全过程;

/**
 * �����Զ����FileSystemClassLoader
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class Demo03 {
	public static void main(String[] args) throws Exception{
		FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjava");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("d:/myjava");
		
		Class<?> c = loader.loadClass("com.bjsxt.gaoqi.HelloWorld");
		Class<?> c2 = loader.loadClass("com.bjsxt.gaoqi.HelloWorld");
		Class<?> c3 = loader2.loadClass("com.bjsxt.gaoqi.HelloWorld");

		Class<?> c4 = loader2.loadClass("java.lang.String");
		Class<?> c5 = loader2.loadClass("com.bjsxt.test.Demo01");
		
		
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());	//ͬһ���࣬����ͬ�ļ��������أ�JVM��ΪҲ�ǲ���ͬ����
		System.out.println(c4.hashCode());
		System.out.println(c4.getClassLoader());	//�����������
		System.out.println(c3.getClassLoader());	//�Զ�����������
		System.out.println(c5.getClassLoader());	//ϵͳĬ�ϵ��������
		
	}
}
