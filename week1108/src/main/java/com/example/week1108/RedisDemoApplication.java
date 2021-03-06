package com.example.week1108;

import com.example.week1108.lock.RedisLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisDemoApplication {

    private final static String LOCK = "redis_lock";

    private final static int EXPIRE = 3;

    private static int amount = 10;

    public static void lockTest() {
        System.out.println("lock test:: start sleep 10");

        if (!RedisLock.getInstance().lock(LOCK, EXPIRE)) {
            System.out.println("获取锁失败");
            return;
        }

        try {
            Thread.sleep(10000);
            amount -= 1;
            System.out.printf("库存减一 amount: %d\n", amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RedisLock.getInstance().release(LOCK);
        System.out.println("lock test:: end");
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RedisDemoApplication.class, args);
        Thread thread1 = new Thread(RedisDemoApplication::lockTest);
        Thread thread2 = new Thread(RedisDemoApplication::lockTest);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        Thread thread3 = new Thread(RedisDemoApplication::lockTest);
        thread3.start();
        thread3.join();
    }

}
