package com.coding.entity;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    // 这样写的话，key是商品编号，value是商品信息。
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem v : items.values()) {
            totalCount += v.getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (CartItem v : items.values()) {
            totalPrice = totalPrice.add(v.getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            // 之前没添加过此商品
            items.put(cartItem.getId(), cartItem);
        } else {
            // 之前有此商品
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getCount())));
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(int id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clearCart() {
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateItem(int id, int count) {
        CartItem item = items.get(id);
        item.setCount(count);
        item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getCount())));
    }
}
