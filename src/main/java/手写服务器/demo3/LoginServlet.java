package 手写服务器.demo3;

public class LoginServlet extends Servlet {

    @Override
    public void doGet(Request request, Response response) throws Exception {
        String name = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        if (login(name, pwd)) {
            response.println("登陆成功");
        } else {
            response.println("帐号或者密码错误");
        }

    }

    public boolean login(String name, String pwd) {
        return name.equals("wang") && pwd.equals("123456");
    }

    @Override
    public void doPost(Request request, Response response) throws Exception {

    }
}
