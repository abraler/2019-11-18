import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

public class Useblockqueue {

    private static BlockingQueue<String>queue=new ArrayBlockingQueue<>(1);//必须定义容量
    /*
    private static BlockingQueue<String>queue=new PriorityBlockingQueue<>();//优先级阻塞队列

    private static BlockingQueue<String>queue=new LinkedBlockingDeque<>();//没有容量限制

    */
    public static void main(String[] args) {
        Thread produce=new Producer();
        Thread costomer=new Customer();
        produce.start();
        costomer.start();
    }
    public static class Producer extends Thread{
        @Override
        public void run() {
            Random random=new Random();

            while(true){
                try {
                    int messge=random.nextInt(100);
                    queue.put(String.valueOf(messge));
                    System.out.println("放入数据"+messge);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Customer extends Thread{
        @Override
        public void run() {
            while(true){
                try {

                    System.out.println("取出数据"+queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
