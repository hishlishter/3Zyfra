package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimerTaskTest {
    @Test
    public void testStartTimer() throws InterruptedException {
        final boolean[] taskExecuted = {false};

        TimerTask.startTimer(() -> taskExecuted[0] = true, 1);

        // Ждём немного больше одной секунды
        Thread.sleep(1100);

        assertTrue(taskExecuted[0], "Задача должна быть выполнена после задержки");
    }
}
