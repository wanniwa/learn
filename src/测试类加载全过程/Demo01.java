package 测试类加载全过程;

public class Demo01 {
	static{
		System.out.println("静态代码块Demo01");
	}
	
	
	public static void main(String[] args) throws Exception {
		// System.out.println("Demo01��main������");
		// System.out.println(System.getProperty("java.class.path"));
		
		//��������
		new A();
		System.out.println(A.width);
		Class.forName("测试类加载全过程.Demo01");
		
		
		//��������
//		System.out.println(A.MAX);
//		A[] as = new A[10];
// 		System.out.println(B.width);
		
	}
}

class B  extends A {
	static {
		System.out.println("��̬��ʼ��B");
	}
}

class A extends A_Father {
	public static int width=100;
	public static final  int MAX=100; 
	
	static {
		System.out.println("静态初始化块A");
		width=300;
	}
	public A(){
		System.out.println("类A的构造方法");
	}
}

class A_Father extends Object {
	static {
		System.out.println("A_Father");
	}
}
