package org.roy.kata16.external;

import org.roy.kata16.entity.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemService {
    private static ItemService instance;

    /**
     * Can be called more than once.
     */
    public static void initialize() {
        instance = new ItemService();
    }

    // Singleton instead of autowire or micro service
    public static ItemService getItemService() {
        return instance;
    }

    private final Map<String, Item> inventory = new HashMap<>();

    private ItemService() {
        addItem("a01a5649-2a45-4938-84af-9889406a26ce", new ItemStub("Learning to Ski", true));
        addItem("62ae4333-04a5-4f65-a1a9-bfd0593aad95", new ItemStub("First Aid", false));
    }

    private void addItem(String id, Item item) {
        inventory.put(id, item);
    }

    private static class ItemStub implements Item {
        private final String name;
        private final boolean isPhysicalProduct;

        public ItemStub(String name, boolean isPhysicalProduct) {
            this.name = name;
            this.isPhysicalProduct = isPhysicalProduct;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public boolean isPhysicalProduct() {
            return isPhysicalProduct;
        }

        @Override
        public boolean isBook() {
            return false;
        }

        @Override
        public boolean isMembership() {
            return false;
        }
    }
}
