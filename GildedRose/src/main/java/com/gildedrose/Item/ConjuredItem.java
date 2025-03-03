package com.gildedrose.Item;

public class ConjuredItem extends Item implements ItemInterface {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (this.sellIn < 0) {
            if (this.quality >= 4) {
                this.quality = this.quality - 4;
            }
        } else {
            if (this.quality >= 2) {
                this.quality = this.quality - 2;
            }
        }

        this.sellIn -= 1;
    }
}
