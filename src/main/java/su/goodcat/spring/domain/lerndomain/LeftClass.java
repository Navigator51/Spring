package su.goodcat.spring.domain.lerndomain;

import lombok.SneakyThrows;

import java.time.LocalDateTime;

// класс создаёт 2 потока. 1й засыпает, второй его будит
public class LeftClass {
private static final String pupok = "pupok";

    public void method() throws InterruptedException {
        Thread thread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    if (i == 500){
                        synchronized (pupok){
                            pupok.wait();
                        }
                    }
                    System.out.println("жопа глаз унитаз "+ i + "  " + LocalDateTime.now() + Thread.currentThread().getName());
                }
            }
        };
        thread.start();
        Thread.sleep(50);

        for (int i = 1; i <= 1000; i++) {
            if (i==500){
                synchronized (pupok) {
                    pupok.notify();
                }
            }
            System.out.println("ass eye WC "+ i + " " + LocalDateTime.now() + Thread.currentThread().getName());
        }

    }
}
