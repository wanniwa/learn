package 手写服务器.demo1;

import 网络编程.TCP.chat.demo03.CloseUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 封装响应信息
 */
public class Response {
    private StringBuilder headInfo;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";
    private int len = 0;
    private StringBuilder content;
    private BufferedWriter bw;


    public Response() {
        this.headInfo = new StringBuilder();
        this.content = new StringBuilder();
    }

    public Response(OutputStream outputStream) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(outputStream));
    }
    public Response(Socket socket) throws IOException {
        this(socket.getOutputStream());
    }

    public Response print(String info) {
        content.append(info);
        len+=info.getBytes().length;
        return this;
    }
    public Response println(String info) {
        this.print(info).print(CRLF);
        return this;
    }


    /**
     * 构建响应头
     */
    private void createHeadInfo(int code) {
        //1 Http协议版本 状态代码 描述
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code) {
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("NOT FOUND");
                break;
            case 505:
                headInfo.append("SERVER ERROR");
                break;

        }
        headInfo.append(CRLF);
        //2 响应头 Response Head
        headInfo.append("Server:king Server/0.0.1").append(CRLF);
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Content-type:text/html;charset=UTF-8").append(CRLF);
        headInfo.append("Content-Length:").append(len).append(CRLF);
        headInfo.append(CRLF);
    }

    void pushToClient(int code) throws IOException {
        createHeadInfo(code);
        //头信息+分割符
        bw.append(headInfo.toString());
        bw.append(content.toString());
        bw.flush();
    }
    public  void close(){
        CloseUtil.closeAll(bw);
    }
}
