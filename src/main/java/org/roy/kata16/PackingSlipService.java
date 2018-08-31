package org.roy.kata16;

import org.roy.kata16.entity.OrderItem;
import org.roy.kata16.entity.PackingSlip;

public class PackingSlipService implements PurchaseListener {
    private static PackingSlipService instance;

    public static void initialize() {
        instance = new PackingSlipService();
        initializeInstance(instance);
    }

    // Singleton instead of autowire or micro service
    public static PackingSlipService getInstance() {
        return instance;
    }

    static void testInitialize(PackingSlipService packingSlipService) {
        instance = packingSlipService;
        initializeInstance(instance);
    }

    private static void initializeInstance(PackingSlipService packingSlipService) {
        PurchaseService.getInstance().addPurchaseListener(packingSlipService);
    }

    @Override
    public void onPurchase(OrderItem orderItem) {
        PackingSlip packingSlip = new PackingSlip();

        if (orderItem.getItem().isPhysicalProduct()) {
            ServiceLocator.getShippingService().ship(packingSlip);
        }
    }
}