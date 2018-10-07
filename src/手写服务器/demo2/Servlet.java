package 手写服务器.demo2;

public class Servlet {

    public void service(Request request, Response response) {
        response.println("<html lang=\"en\"><head><meta charset=\"UTF-8\"><title>HTTP响应势力</title>" +
                "</head><body>" +
                "欢迎：" + request.getParameter("uname")+
                "</body></html>");
    }
}
