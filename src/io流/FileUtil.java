package io流;

import java.io.*;

public class FileUtil {
    /**
     * 复制文件
     *
     * @param srcPath  数据源地址
     * @param destPath 目标地址
     * @throws IOException
     */
    public static void copyFile(String srcPath, String destPath) throws IOException {
        //1.建立联系源（存在且为文件）
        File src = new File(srcPath);
        File desc = new File(destPath);
        copyFile(src, desc);
    }

    public static void copyFile(File src, File dest) throws IOException {
        if (!src.isFile()) {
            throw new IOException("只能拷贝文件");
        }
        if (src.isDirectory()) {
            throw new IOException(dest.getAbsolutePath()+"不能建立和文件夹同名的文件");
        }
        //2.选择流
        InputStream is = new BufferedInputStream(new FileInputStream(src));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
        //3.文件拷贝 循环+读取+写出
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            os.write(flush, 0, len);
        }
        //强制刷出
        os.flush();
        //关闭流
        os.close();
        is.close();
    }

    /**
     * 拷贝文件夹
     *
     * @param src
     * @param dest
     */
    public static void copyDir(File src, File dest) {
        if (src.isDirectory()) {
            dest = new File(dest, src.getName());
        }
        copyDirDetail(src, dest);
    }

    /**
     * 拷贝文件夹
     *
     * @param srcPath
     * @param destPath
     */
    public static void copyDir(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        copyDir(src, dest);
    }

    public static void copyDirDetail(File src, File dest) {
        if (src.isFile()) {
            try {
                copyFile(src, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(src.isDirectory()){
            dest.mkdirs();
            for (File sub:src.listFiles()){
                copyDirDetail(sub,new File(dest,sub.getName()));
            }
        }
    }


}
