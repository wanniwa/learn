package 测试类加载全过程;

/**
 * ���Լ򵥼��ܽ���(ȡ��)����
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class Demo04 {
	public static void main(String[] args) throws Exception {
		//����ȡ������
//		int a = 3; //0000011
//		System.out.println(Integer.toBinaryString(a^0xff));
		
		//���ܺ��class�ļ�����������������޷����أ���classFormatError
//		FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjava/temp");
//		Class<?> c = loader.loadClass("HelloWorld");
//		System.out.println(c);
		
		DecrptClassLoader loader = new DecrptClassLoader("d:/myjava/temp");
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);
		
	}
}
