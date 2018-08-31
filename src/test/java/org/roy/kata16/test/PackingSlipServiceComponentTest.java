package org.roy.kata16.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.roy.kata16.ServiceLocator;
import org.roy.kata16.entity.Item;
import org.roy.kata16.entity.OrderItem;
import org.roy.kata16.service.PackingSlipService;
import org.roy.kata16.service.PurchaseService;

import static org.mockito.Mockito.*;

public class PackingSlipServiceComponentTest {
    private PurchaseService purchaseService;

    @Before
    public void before() {
        ServiceLocator.testPreInitialize();;
        purchaseService = ServiceLocator.getPurchaseService();
    }

    @Test
    public void onPurchaseIsCalledWhenProcessPurchaseIsInvoked() {
        PackingSlipService packingSlipService = Mockito.spy(new PackingSlipService());
        ServiceLocator.testSetPackingSlipService(packingSlipService);
        ServiceLocator.testInitialize();
        OrderItem orderItemMock = mock(OrderItem.class);
        when(orderItemMock.getItem()).thenReturn(mock(Item.class));

        purchaseService.processPurchase(orderItemMock);

        verify(packingSlipService).onPurchase(orderItemMock);
    }
}
