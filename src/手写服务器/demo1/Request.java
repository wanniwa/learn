package 手写服务器.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Request {
    //请求方式
    private String method;
    //请求资源
    private String url;
    //请求参数
    private Map<String, List<String>> parameterMapValues;

    //内部
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";
    private InputStream is ;
    private String requestInfo;

    public Request() {
        parameterMapValues = new HashMap<>();
    }
    public Request(InputStream is) {
        this();
        this.is = is;
        byte[] data = new byte[20480];
        int len = 0;
        try {
            len = is.read(data);

        requestInfo = new String(data, 0, len);
        } catch (IOException e) {
            return;
        }
        //分析头信息
        parseRequestInfo();
    }

    private void parseRequestInfo() {
        if (null == requestInfo || (requestInfo = requestInfo.trim()).equals("")) {
            return;
        }
        /**
         * 从信息的首行分解出:请求方式 请求路径 请求参数（Get 可能存在）
         *
         *
         */
        String paramString = null;
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
        int idx = requestInfo.indexOf("/");
        this.method = firstLine.substring(0, idx).trim();
        String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();

        if (this.method.equals("post")) {
            this.url = urlStr;
            paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        } else if (this.method.equals("get")) {
            if (urlStr.contains("?")){
                String[] urlArray = urlStr.split("\\?");
                this.url = urlArray[0];
                paramString =urlArray[1];//接收请求参数
            }else {
                this.url = urlStr;
            }
        }
        //请求参数封装到map中
        if (paramString!=null&&!paramString.equals("")){
            parseParams(paramString);
        }
    }

    private void parseParams(String paramString) {
        StringTokenizer token = new StringTokenizer(paramString, "&");
        while (token.hasMoreTokens()) {
            String keyValue = token.nextToken();
            String[] keyValues = keyValue.split("=");
            if (keyValues.length == 1) {
                keyValues = Arrays.copyOf(keyValues, 2);
                keyValues[1] = null;
            }
            String key = keyValues[0].trim();
            String value = null;
        }
    }
}
