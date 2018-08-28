package org.roy.kata16;

import java.util.HashMap;
import java.util.Map;

public class ItemService {
    private static ItemService instance;

    // Singleton to replace autowire or micro service
    synchronized public static ItemService getItemService() {
        if (instance == null) {
            instance = new ItemService();
        }
        return instance;
    }

    private final Map<String, Item> inventory = new HashMap<>();

    private ItemService() {
        addItem("a01a5649-2a45-4938-84af-9889406a26ce", new InventoryItem.PrivateBuilder("Learning to Ski")
                .setPhysicalProduct().get());
        addItem("62ae4333-04a5-4f65-a1a9-bfd0593aad95", new InventoryItem.PrivateBuilder("First Aid")
                .setPhysicalProduct().get());
    }

    private void addItem(String id, Item item) {
        inventory.put(id, item);
    }

    private static class InventoryItem implements Item {
        private final String name;
        private boolean physicalProduct;
        private boolean book;
        private boolean membership;
        private boolean video;

        public InventoryItem(String name) {
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

        private static class PrivateBuilder {
            private final InventoryItem inventoryItem;

            public PrivateBuilder(String name) {
                this.inventoryItem = new InventoryItem(name);
            }

            public PrivateBuilder setPhysicalProduct() {
                inventoryItem.physicalProduct = true;
                return this;
            }

            public PrivateBuilder setBook() {
                inventoryItem.book = true;
                return this;
            }

            public PrivateBuilder setMembership() {
                inventoryItem.membership = true;
                return this;
            }

            public InventoryItem get() {
                return inventoryItem;
            }
        }
    }
}
