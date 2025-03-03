package com.gildedrose.Item;

public class LegendaryItem extends Item implements ItemInterface {

    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.quality = 80;
    }

    public void updateQuality() {
    }
}
