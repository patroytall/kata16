package org.roy.kata16.test.main;

import org.roy.kata16.entity.Item;

public class TestItem implements Item {
    protected final String name;
    protected boolean physicalProduct;
    protected boolean book;
    protected boolean membership;

    public TestItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isPhysicalProduct() {
        return physicalProduct;
    }

    @Override
    public boolean isBook() {
        return book;
    }

    @Override
    public boolean isMembership() {
        return membership;
    }

    @Override
    public String toString() {
        return name;
    }

    public static class Builder extends TestItem {
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
