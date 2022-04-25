package com.coding.threadlocal;

public class OrderDAO {

    public void saveOrder() {
        String name = Thread.currentThread().getName();
//        System.out.println("OrderDAO当前线程[" + name + "]保存的数据是：" + ThreadLocalTest.data.get(name));
        System.out.println("OrderDAO当前线程[" + name + "]保存的数据是：" + ThreadLocalTest.threadLocal.get());
    }
}
