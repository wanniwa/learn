package 手写服务器.demo2;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
    //为每个servlet取一个别名
    private Map<String, Servlet> servlet;
    //为url --->login
    private Map<String, String> mapping;

    public ServletContext() {
        servlet = new HashMap<>();
        mapping = new HashMap<>();
    }

    public Map<String, Servlet> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, Servlet> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
