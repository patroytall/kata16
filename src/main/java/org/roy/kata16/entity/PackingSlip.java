package org.roy.kata16.entity;

public class PackingSlip {
    private final Item item;

    public PackingSlip(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "packing slip - " + item;
    }
}
