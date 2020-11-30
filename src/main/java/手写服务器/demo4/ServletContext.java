package 手写服务器.demo4;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
    //为每个servlet取一个别名 存报名类名完整路径
    private Map<String, String> servlet;
    //为url --->login
    private Map<String, String> mapping;

    public ServletContext() {
        servlet = new HashMap<>();
        mapping = new HashMap<>();
    }

    public Map<String, String> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, String> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
