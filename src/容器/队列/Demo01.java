package 容器.队列;


import java.util.ArrayDeque;
import java.util.Queue;

public class Demo01 {
    public static void main(String[] args) {
        Queue<Request> queue = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            final int num = i;
            queue.offer(new Request() {
                            @Override
                            public void deposit() {
                                System.out.println("第" + num + "个人，办理存款业务，存款额度为：" + (Math.random() * 10000));
                            }
                        }

            );
        }
        dealWith(queue);
    }

    public static void dealWith(Queue<Request> que) {
        Request request = null;
        while (null != (request = que.poll())) {
            request.deposit();
        }
    }
}

interface Request {
    void deposit();
}
