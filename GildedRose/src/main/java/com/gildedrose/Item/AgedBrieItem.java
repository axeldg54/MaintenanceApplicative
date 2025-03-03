package com.gildedrose.Item;

public class AgedBrieItem extends Item implements ItemInterface {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
        this.sellIn -= 1;
    }
}
