package org.roy.kata16;

import org.roy.kata16.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class PurchaseService {
    private static PurchaseService instance;

    public static void initialize() {
        instance = new PurchaseService();
    }

    // Singleton instead of autowire or micro service
    public static PurchaseService getInstance() {
        return instance;
    }

    private List<PurchaseListener> purchaseListeners = new ArrayList<>();

    public void addPurchaseListener(PurchaseListener purchaseListener) {
        purchaseListeners.add(purchaseListener);
    }

    public void processPurchase(OrderItem orderItem) {
        for (PurchaseListener purchaseListener : purchaseListeners) {
            purchaseListener.onPurchase(orderItem);
        }
    }
}