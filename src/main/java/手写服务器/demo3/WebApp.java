package 手写服务器.demo3;

import java.util.Map;

public class WebApp {
    private static ServletContext context;
    static {
        context = new ServletContext();
        Map<String, String> mapping = context.getMapping();
        mapping.put("/login", "login");
        mapping.put("/log", "login");
        mapping.put("/reg", "register");

        Map<String, String> servlet = context.getServlet();
        servlet.put("login", "手写服务器.demo3.LoginServlet");
        servlet.put("register", "手写服务器.demo3.RegisterServlet");

    }

    public static Servlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (url==null||url.trim().equals("")) {
            return null;
        }
        // 根据字符串创建对象
        String name = context.getServlet().get(context.getMapping().get(url));
        return (Servlet) Class.forName(name).newInstance();
        // return context.getServlet().get(context.getMapping().get(url));
    }
}
