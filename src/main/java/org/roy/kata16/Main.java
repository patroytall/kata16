package org.roy.kata16;

import org.roy.kata16.external.ItemService;

public class Main {

    public static void main(String[] args) {
        initializeServices();
    }

    private static void initializeServices() {
        PurchaseService.initialize();
        ItemService.initialize();

        PackingSlipService.initialize();
    }
}
