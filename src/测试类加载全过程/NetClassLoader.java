package 测试类加载全过程;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * �����������
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class NetClassLoader extends ClassLoader {
	
	//com.bjsxt.test.User   --> www.sxt.cn/myjava/  com/bjsxt/test/User.class      
	private String rootUrl;
	
	public NetClassLoader(String rootUrl){
		this.rootUrl = rootUrl;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		Class<?> c = findLoadedClass(name);
		
		//Ӧ��Ҫ�Ȳ�ѯ��û�м��ع�����ࡣ����Ѿ����أ���ֱ�ӷ��ؼ��غõ��ࡣ���û�У�������µ��ࡣ
		if(c!=null){
			return c;
		}else{
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name);	   //ί�ɸ��������
			} catch (Exception e) {
//				e.printStackTrace();
			}
			
			if(c!=null){
				return c;
			}else{
				byte[] classData = getClassData(name);
				if(classData==null){
					throw new ClassNotFoundException();
				}else{
					c = defineClass(name, classData, 0,classData.length);
				}
			}
			
		}
		
		return c;
		
	}
	
	private byte[] getClassData(String classname){   //com.bjsxt.test.User   d:/myjava/  com/bjsxt/test/User.class
		String path = rootUrl +"/"+ classname.replace('.', '/')+".class";
		
//		IOUtils,����ʹ���������е�����ת���ֽ�����
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			URL url = new URL(path);
			is  = url.openStream();
			
			byte[] buffer = new byte[1024];
			int temp=0;
			while((temp=is.read(buffer))!=-1){
				baos.write(buffer, 0, temp);
			}
			
			return baos.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(baos!=null){
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
