package io流.其它流;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
    private String filePath;
    private String fileName;
    private int size;
    private long length;
    private long blockSize;
    private List<String> blockPath;
    /**
     * 分割后的存放目录
     */
    private String destBlockPath;


    public SplitFile() {
        blockPath = new ArrayList<>();

    }

    public SplitFile(String filePath, String destBlockPath) {
        this(filePath, 1024, destBlockPath);
    }

    public SplitFile(String filePath, long blockSize, String destBlockPath) {
        this();
        this.filePath = filePath;
        this.blockSize = blockSize;
        this.destBlockPath = destBlockPath;
        init();
    }

    private void initPathName() {
        for (int i = 0; i < size; i++) {
            this.blockPath.add(destBlockPath + this.fileName + ".part" + i);
        }
    }

    /**
     * 初始化操作 计算块数 确认文件名
     */
    public void init() {
        File src;
        if (null == filePath || !(((src = new File(filePath)).exists()))) {
            return;
        }
        if (src.isDirectory()) {
            return;
        }
        //文件名
        this.fileName = src.getName();
        this.length = src.length();
        if (this.blockSize > length) {
            this.blockSize = length;
        }
        //确定块数
        size = (int) Math.ceil(length * 1.0 / this.blockSize);
        //确定文件路径
        initPathName();
    }

    public static void main(String[] args) throws IOException {
        SplitFile file = new SplitFile("print.txt", 5, "");
        //file.split("");
        //file.merge1("mergeFile.text");
        file.merge2("mergeFile2.text");
        System.out.println(file.size);
    }

    public void split(String destPath) throws FileNotFoundException {
        long beginPos = 0;
        long actualBlockSize = blockSize;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                //最后一块
                actualBlockSize = this.length - beginPos;
            }
            splitDetail(i, beginPos, actualBlockSize);
            beginPos += actualBlockSize;
        }
    }

    /**
     * 文件的分割输入输出
     *
     * @param idx
     * @param beginPos
     * @param actualBlockSize
     */
    private void splitDetail(int idx, long beginPos, long actualBlockSize) throws FileNotFoundException {

        File src = new File(this.filePath);
        File dest = new File(this.blockPath.get(idx));

        try (RandomAccessFile raf = new RandomAccessFile(src, "r");
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            raf.seek(beginPos);
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1 != (len = raf.read(flush))) {
                if (actualBlockSize - len > 0) {
                    bos.write(flush, 0, len);
                    actualBlockSize -= len;
                } else {
                    bos.write(flush, 0, (int) actualBlockSize);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void merge1(String destPath) throws IOException {
        File dest = new File(destPath);
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(dest, true));
            for (int i = 0; i < this.blockPath.size(); i++) {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i))));
                byte[] flush = new byte[1024];
                int len = 0;
                while (-1 != (len = bis.read(flush))) {
                    System.out.println();
                    bos.write(flush, 0, len);
                }
                bos.flush();
                bis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (bos != null) {
                bos.close();
            }
        }
    }

    public void merge2(String destPath) throws IOException {
        File dest = new File(destPath);
        SequenceInputStream sis= null;
        try (
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest, true));

                ){

            Vector<InputStream> vector = new Vector<>();
            for (String aBlockPath : this.blockPath) {
                vector.add(new BufferedInputStream(new FileInputStream(new File(aBlockPath))));
            }
            sis =new SequenceInputStream(vector.elements());
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1 != (len = sis.read(flush))) {
                System.out.println();
                bos.write(flush, 0, len);
            }
            bos.flush();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (sis != null) {
                sis.close();
            }
        }
    }
}
