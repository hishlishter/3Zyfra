package org.example;

public class TimerTask {
    public static void startTimer(Runnable task, int seconds) {
        new Thread(() -> {
            try {
                Thread.sleep(seconds * 1000);
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Ошибка таймера.");
            }
        }).start();
    }
}
