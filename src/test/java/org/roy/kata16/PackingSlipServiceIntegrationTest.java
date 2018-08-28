package org.roy.kata16;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class PackingSlipServiceIntegrationTest {
    private static PurchaseService purchaseService;

    @BeforeClass
    public static void beforeClass() {
        PurchaseService.initialize();
        purchaseService = PurchaseService.getInstance();
    }

    @Test
    public void onPurchaseIsCalledWhenProcessPurchaseIsInvoked() {
        PackingSlipService packingSlipService = Mockito.spy(new PackingSlipService());
        PackingSlipService.testInitialize(packingSlipService);
        purchaseService.processPurchase(null);
        verify(packingSlipService).onPurchase(null);
    }
}
