package org.roy.kata16.external;

import org.roy.kata16.entity.PackingSlip;

public class ShippingServiceStub implements ShippingService {
    @Override
    public void ship(PackingSlip packingSlip) {
        System.out.println("shipping packing slip: " + packingSlip);
    }
}
