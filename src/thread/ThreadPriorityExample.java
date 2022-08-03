package thread;

public class ThreadPriorityExample {
    public static void main(String[] args) {

        Runnable r1 = new Thread1();
        Thread t1 = new Thread(r1);

        Runnable r2 = new Thread2();
        Thread t2 = new Thread(r2);

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }
}