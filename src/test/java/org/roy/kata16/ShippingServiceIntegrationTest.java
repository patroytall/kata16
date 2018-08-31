package org.roy.kata16;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.roy.kata16.entity.Item;
import org.roy.kata16.entity.OrderItem;
import org.roy.kata16.external.ShippingService;

import static org.mockito.Mockito.*;

public class ShippingServiceIntegrationTest {
    private static PurchaseService purchaseService;

    private final Item itemMock = mock(Item.class);;
    private final OrderItem orderItemMock = mock(OrderItem.class);
    private final ShippingService shippingServiceMock = mock(ShippingService.class);

    @BeforeClass
    public static void beforeClass() {
        PurchaseService.initialize();
        PackingSlipService.initialize();
        ServiceLocator.initialize();
        purchaseService = PurchaseService.getInstance();
    }

    @Before
    public void before() {
        when(orderItemMock.getItem()).thenReturn(itemMock);
        ServiceLocator.setShippingService(shippingServiceMock);
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
