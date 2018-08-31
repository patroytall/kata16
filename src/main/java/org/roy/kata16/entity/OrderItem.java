package org.roy.kata16.entity;

public class OrderItem {
    private final Item item;
    private final MembershipOrderDetails subscriptionOrderDetails;

    public OrderItem(Item item) {
        this(item, null);
    }

    public OrderItem(Item item, MembershipOrderDetails subscriptionOrderDetails) {
        this.item = item;
        this.subscriptionOrderDetails = subscriptionOrderDetails;
    }
    public Item getItem() {
        return item;
    }
}
