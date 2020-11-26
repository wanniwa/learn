package 多线程.方法一Thread;

public class Game {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        rabbit.start();
        tortoise.start();
    }
}
