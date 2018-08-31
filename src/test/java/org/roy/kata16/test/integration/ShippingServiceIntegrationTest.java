package org.roy.kata16.test.integration;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.roy.kata16.service.PackingSlipService;
import org.roy.kata16.service.PurchaseService;
import org.roy.kata16.ServiceLocator;
import org.roy.kata16.entity.Item;
import org.roy.kata16.entity.OrderItem;
import org.roy.kata16.external.ShippingService;

import static org.mockito.Mockito.*;

public class ShippingServiceIntegrationTest {
    private PurchaseService purchaseService;

    private final Item itemMock = mock(Item.class);;
    private final OrderItem orderItemMock = mock(OrderItem.class);
    private final ShippingService shippingServiceMock = mock(ShippingService.class);

    @Before
    public void before() {
        initializeServices();
        when(orderItemMock.getItem()).thenReturn(itemMock);
        ServiceLocator.testSetShippingService(shippingServiceMock);
    }

    private void initializeServices() {
        ServiceLocator.initialize();
        purchaseService = ServiceLocator.getPurchaseService();
    }

    @Test
    public void purchaseOfPhysicalProductGeneratesPackingSlipForShipping() {
        when(itemMock.isPhysicalProduct()).thenReturn(true);
        purchaseService.processPurchase(orderItemMock);
        verify(shippingServiceMock, times(1)).ship(notNull());
    }

    @Test
    public void purchaseOfNonPhysicalProductDoesNotGeneratesPackingSlipForShipping() {
        purchaseService.processPurchase(orderItemMock);
        verify(shippingServiceMock, times(0)).ship(null);
    }
}
