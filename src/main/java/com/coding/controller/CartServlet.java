package com.coding.controller;

import com.coding.entity.Cart;
import com.coding.entity.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class CartServlet extends BaseServlet{

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("加入购物车");
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, BigDecimal.valueOf(99), BigDecimal.valueOf(99)));
        System.out.println(cart);
    }
}
