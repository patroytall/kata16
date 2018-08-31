package org.roy.kata16.service;

import org.roy.kata16.ChainedService;
import org.roy.kata16.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class PurchaseService implements ChainedService {
    private List<PurchaseListener> purchaseListeners = new ArrayList<>();

    public void addPurchaseListener(PurchaseListener purchaseListener) {
        purchaseListeners.add(purchaseListener);
    }

    public void processPurchase(OrderItem orderItem) {
        for (PurchaseListener purchaseListener : purchaseListeners) {
            purchaseListener.onPurchase(orderItem);
        }
    }

    @Override
    public void initialize() {
    }
}