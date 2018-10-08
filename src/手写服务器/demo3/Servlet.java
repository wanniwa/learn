package 手写服务器.demo3;

public abstract class Servlet {

    public void service(Request request, Response response) throws Exception {
        this.doGet(request, response);
        this.doPost(request, response);

        // response.println("<html lang=\"en\"><head><meta charset=\"UTF-8\"><title>HTTP响应势力</title>" +
        //         "</head><body>" +
        //         "欢迎：" + request.getParameter("uname")+
        //         "</body></html>");
    }

    public abstract void doGet(Request request, Response response) throws Exception;
    public abstract void doPost(Request request, Response response) throws Exception;
}
