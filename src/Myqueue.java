public class Myqueue {
    private int[]a=new int [10];

    private  int front=0;
    private int rear=0;
    private int size=0;
    private Object full=new Object();
    private Object empty=new Object();
    public void put(int messge) throws InterruptedException {
        while(size==a.length){
            synchronized (full) {
                full.wait();
            }
        }
        synchronized(this) {
            a[rear] = messge;
            rear = (rear + 1) % a.length;
            size++;
        }
        synchronized (empty) {
            empty.notify();
        }
    }
    public  int take() throws InterruptedException {
        while(size==0){
            synchronized (empty){
                empty.wait();
            }
        }
        int message;
        synchronized(this) {
            message = a[front];
            front = (front + 1) % a.length;
            size--;
        }
        synchronized (full) {
            full.notify();
        }
        return message;
    }
}
