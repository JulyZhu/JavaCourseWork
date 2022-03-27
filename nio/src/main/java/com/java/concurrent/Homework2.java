package com.java.concurrent;

import java.util.concurrent.*;

public class Homework2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，

        // 异步执行 下面方法
        //线程池一
//        ExecutorService executor = Executors.newFixedThreadPool(1);
        //线程池二
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        //线程池三
        ExecutorService executor = Executors.newCachedThreadPool();
        Future future=executor.submit(new Meth01());
        int result = (int) future.get(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }

    static class Meth01 implements Callable{

        @Override
        public Object call() throws Exception {
            return Homework2.sum();
        }
    }
}
