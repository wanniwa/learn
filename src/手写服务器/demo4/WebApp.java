package 手写服务器.demo4;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WebApp {
    private static ServletContext contxt;
    static {
        contxt = new ServletContext();


        try {
            //获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //获取解析器
            SAXParser sax = factory.newSAXParser();
            //指定xml+处理器
            WebHandler web = new WebHandler();
            sax.parse(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("com/bjsxt/server/demo4/web.xml"), web);
            //将list 转成Map
            contxt =new ServletContext();
            Map<String,String> servlet =contxt.getServlet();

            //servlet-name  servlet-class
            for(Entity entity:web.getEntityList()){
                servlet.put(entity.getName(), entity.getClz());

            }

            //url-pattern servlet-name
            Map<String,String> mapping =contxt.getMapping();
            for(Mapping mapp:web.getMappingList()){
                List<String> urls =mapp.getUrlPattern();
                for(String url:urls ){
                    mapping.put(url, mapp.getName());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Servlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (url==null||url.trim().equals("")) {
            return null;
        }
        // 根据字符串创建对象
        String name = contxt.getServlet().get(contxt.getMapping().get(url));
        return (Servlet) Class.forName(name).newInstance();
        // return context.getServlet().get(context.getMapping().get(url));
    }
}
