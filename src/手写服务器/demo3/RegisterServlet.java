package 手写服务器.demo3;

public class RegisterServlet extends Servlet {
    @Override
    public void doGet(Request request, Response response) throws Exception {

    }

    @Override
    public void doPost(Request request, Response response) throws Exception {
        response.println("<html lang=\"en\"><head><meta charset=\"UTF-8\"><title>返回注册</title>" +
                "</head><body>" +
                "欢迎：" + request.getParameter("你的用户名为："+request.getParameter("uname"))+
                "</body></html>");
    }
}
