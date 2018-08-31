package org.roy.kata16;

import org.roy.kata16.external.ShippingService;
import org.roy.kata16.external.ShippingServiceStub;

public class ServiceLocator {
    private static ShippingService shippingService;

    public static void initialize() {
        shippingService = new ShippingServiceStub();
    }

    public static ShippingService getShippingService() {
        return shippingService;
    }

    // Test hooks

    public static void setShippingService(ShippingService shippingService) {
        ServiceLocator.shippingService = shippingService;
    }
}