package thread;

import javax.swing.*;

public class IOBlockExample {
    public static void main(String[] args) {
        Runnable r = new CountDown();
        Thread t1 = new Thread(r);

        t1.start();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        t1.interrupt();
    }
}

class CountDown implements Runnable {
    private int count = 3;
    private int sleepTime = 1000;

    public CountDown(){}

    @Override
    public void run() {
        while (count > 0){
            System.out.println(count--);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                break;
            }
        }

        if (count > 0) {
            System.out.println("시간 내에 값을 입력하셨습니다.");
        } else {
            System.out.println("시간 내에 값을 입력하지 못하셨습니다.");
            JOptionPane.getRootFrame().dispose();
        }
    }
}