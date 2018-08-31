package org.roy.kata16;

import org.roy.kata16.entity.PackingSlip;
import org.roy.kata16.external.*;
import org.roy.kata16.service.PackingSlipService;
import org.roy.kata16.service.PurchaseService;

public class ServiceLocator {
    private static ShippingService shippingService ;
    private static RoyaltyService royaltyService;

    private static PurchaseService purchaseService;
    private static PackingSlipService packingSlipService;

    public static void initialize() {
        setServiceInstances();
        initializeServices();
    }

    private static void initializeServices() {
        ItemService.initialize();

        purchaseService.initialize();
        packingSlipService.initialize();
    }

    private static void setServiceInstances() {
        shippingService  = new ShippingServiceStub();
        royaltyService  = new RoyaltyServiceStub();

        purchaseService = new PurchaseService();
        packingSlipService = new PackingSlipService();
    }

    public static PurchaseService getPurchaseService() {
        return purchaseService;
    }

    public static ShippingService getShippingService() {
        return shippingService;
    }

    public static RoyaltyService getRoyaltyService() {
        return royaltyService;
    }

    //
    // Test Hooks
    //

    public static void testPreInitialize() {
        setServiceInstances();
    }

    public static void testInitialize() {
        initializeServices();
    }

    public static void testSetPackingSlipService(PackingSlipService packingSlipService) {
        ServiceLocator.packingSlipService = packingSlipService;
    }

    public static void testSetShippingService(ShippingService shippingService) {
        ServiceLocator.shippingService = shippingService;
    }
}