package thread;

class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            System.out.printf("-");
        }
        System.out.println("Priority of t1 = " + Thread.currentThread().getPriority());
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            System.out.printf("|");
        }
        System.out.println("Priority of t2 = " + Thread.currentThread().getPriority());
    }
}

public class ThreadExample {
    static Long startTime = 0L;

    public static void main(String[] args) {
        Runnable r1 = new Thread1();
        Thread t1 = new Thread(r1);

        Runnable r2 = new Thread2();
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        startTime = System.currentTimeMillis();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
