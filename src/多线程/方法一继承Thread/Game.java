package 多线程.方法一继承Thread;

public class Game {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        rabbit.start();
        tortoise.start();
    }
}
