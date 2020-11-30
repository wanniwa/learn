package 多线程.线程操作;

public class StopDemo {
    public static void main(String[] args) {
        Study s = new Study();
        new Thread(s).start();
        for (int i = 0; i < 500; i++) {
            if (250 == i) {
                s.stop();
            }
            System.out.println("main线i="+i);
        }
    }
}
class Study implements Runnable{

    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            System.out.println("study thread ");
        }
    }
    public void  stop(){
        this.flag = false;
    }
}
