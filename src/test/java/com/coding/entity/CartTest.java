package com.coding.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {

    private Cart cart;

    @BeforeEach
    void creatCart() {
        cart = new Cart();
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, BigDecimal.valueOf(99), BigDecimal.valueOf(99)));
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, BigDecimal.valueOf(99), BigDecimal.valueOf(99)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, BigDecimal.valueOf(99), BigDecimal.valueOf(99)));
    }

    @Test
    void addItem() {
        cart.addItem(new CartItem(3, "小黄书", 1, BigDecimal.valueOf(3), BigDecimal.valueOf(3)));
        assertEquals(BigDecimal.valueOf(300), cart.getTotalPrice());
        assertEquals(4, cart.getTotalCount());
        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        cart.deleteItem(1);
        assertEquals(BigDecimal.valueOf(99), cart.getTotalPrice());
        System.out.println(cart);
    }

    @Test
    void clearCart() {
        cart.clearCart();
        assertEquals(BigDecimal.ZERO, cart.getTotalPrice());
        System.out.println(cart);
    }

    @Test
    void updateItem() {
        cart.updateItem(1, 5);
        assertEquals(BigDecimal.valueOf(99).multiply(BigDecimal.valueOf(6)), cart.getTotalPrice());
        System.out.println(cart);
    }
}