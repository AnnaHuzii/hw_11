package TaskOne;

import static java.lang.Thread.sleep;

public class TimeTests {
    public static void main(String[] args) {
        Timer timer = new Timer();
        new Thread(() -> {
            int count = 1;
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count + " seconds passed");
                timer.setTime(count);
                count++;
            }
        }, "Counter").start();

        new Thread(() -> {
            int time = 0;
            while (true) {
                time = timer.getTime();
                if (time != 0 && time % 5 == 0) {
                    System.out.println("5 seconds have passed");
                }
            }
        }, "Messenger").start();
    }
}