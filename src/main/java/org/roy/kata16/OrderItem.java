package org.roy.kata16;

public class OrderItem {
    private final String name;
    private final MembershipOrderDetails subscriptionOrderDetails;

    public OrderItem(String name) {
        this(name, null);
    }

    public OrderItem(String name, MembershipOrderDetails subscriptionOrderDetails) {
        this.name = name;
        this.subscriptionOrderDetails = subscriptionOrderDetails;
    }
}
