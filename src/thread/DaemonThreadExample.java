package thread;

public class DaemonThreadExample implements Runnable{
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new DaemonThreadExample());
        t.setDaemon(true);
        t.start();

        for (int i = 0; i <= 1000; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            System.out.println(i);

            if(i % 10 == 0) autoSave = true;
        }

        System.out.println("프로그램을 종료합니다");
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e){}

            if(autoSave) {
                autoSave();
                autoSave = false;
            }
        }
    }

    public void autoSave() {
        System.out.println("자동 저장 되었습니다");
    }
}
