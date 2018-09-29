package 多线程.同步.生产者消费者;

public class Movie {
    private String pic ;
    /**
     * 播放
     * @param pic
     */
    public void play(String pic){
        this.pic = pic;
    }
    public void watch(){
        System.out.println(pic);
    }
}
