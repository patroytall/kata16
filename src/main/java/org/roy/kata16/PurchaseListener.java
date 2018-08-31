package org.roy.kata16;

import org.roy.kata16.entity.OrderItem;

public interface PurchaseListener {
    void onPurchase(OrderItem orderItem);
}
