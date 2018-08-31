package org.roy.kata16.test.main;

import org.roy.kata16.entity.Item;

public class TestItem implements Item {
    private final String name;
    private boolean physicalProduct;
    private boolean book;
    private boolean membership;
    private boolean video;

    public TestItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isPhysicalProduct() {
        return false;
    }

    @Override
    public boolean isBook() {
        return false;
    }

    @Override
    public boolean isMembership() {
        return false;
    }

    private class Builder extends TestItem {
        public Builder(String name) {
            super(name);
        }

        public Builder setPhysicalProduct() {
            physicalProduct = true;
            return this;
        }

        public Builder setBook() {
            book = true;
            return this;
        }

        public Builder setMembership() {
            membership = true;
            return this;
        }

        public Item get() {
            return this;
        }
    }
}
