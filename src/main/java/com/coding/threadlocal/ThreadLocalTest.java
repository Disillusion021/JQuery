package com.coding.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {

    public static Map<String, Object> data = new Hashtable<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    public static Random random = new Random();

    public static class Task implements Runnable {
        @Override
        public void run() {
            // 在run()方法中随机生成一个变量，这个变量就是线程要关联的数据，然后以当前线程名为key保存到map中
            // 生成0-999的随机整数
            int i = random.nextInt(1000);
            // 获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name + "]生成的随机数是" + i);
            // data.put(name, i);
            threadLocal.set(i);
            // 做一些别的业务操作,把数据保存到ThreadLocal里， 只要是同一个线程，可以很方便的跨层取数据。比如从Service或Dao层里取数据。
            new OrderService().creatOrder();
            // 在run()方法快结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
            // Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程[" + name + "]快结束时取出关联的数据是" + o);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
}
