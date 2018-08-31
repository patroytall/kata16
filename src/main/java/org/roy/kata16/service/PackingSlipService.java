package org.roy.kata16.service;

import org.roy.kata16.ChainedService;
import org.roy.kata16.ServiceLocator;
import org.roy.kata16.entity.OrderItem;
import org.roy.kata16.entity.PackingSlip;

public class PackingSlipService implements PurchaseListener, ChainedService {
    @Override
    public void initialize() {
        ServiceLocator.getPurchaseService().addPurchaseListener(this);
    }

    @Override
    public void onPurchase(OrderItem orderItem) {
        PackingSlip packingSlip = new PackingSlip(orderItem.getItem());

        if (orderItem.getItem().isPhysicalProduct()) {
            ServiceLocator.getShippingService().ship(packingSlip);
        }
    }
}