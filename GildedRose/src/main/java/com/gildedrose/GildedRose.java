package com.gildedrose;

import com.gildedrose.Item.ItemInterface;

class GildedRose {
    ItemInterface[] items;

    public GildedRose(ItemInterface[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (ItemInterface item : items) {
            item.updateQuality();
        }
    }
}