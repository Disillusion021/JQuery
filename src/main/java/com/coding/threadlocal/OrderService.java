package com.coding.threadlocal;

public class OrderService {
    public void creatOrder() {
        String name = Thread.currentThread().getName();
        // System.out.println("OrderService当前线程[" + name + "]保存的数据是：" + ThreadLocalTest.data.get(name));
        System.out.println("OrderService当前线程[" + name + "]保存的数据是：" + ThreadLocalTest.threadLocal.get());
        new OrderDAO().saveOrder();
    }
}
