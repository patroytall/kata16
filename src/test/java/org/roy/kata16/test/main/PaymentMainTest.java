package org.roy.kata16.test.main;

import org.junit.Test;
import org.roy.kata16.Main;
import org.roy.kata16.ServiceLocator;
import org.roy.kata16.entity.Item;
import org.roy.kata16.entity.OrderItem;

public class PaymentMainTest {
    @Test
    public void purchaseOfPhysicalProductGeneratesPackingSlipForShipping() {
        Main.main(null);

        Item item = new TestItem.Builder("testItem").setPhysicalProduct().get();
        OrderItem orderItem = new OrderItem(item);
        ServiceLocator.getPurchaseService().processPurchase(orderItem);
    }
}