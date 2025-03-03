package com.gildedrose.Item;

public class NormalItem extends Item implements ItemInterface {

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (this.sellIn < 0) {
            if (this.quality >= 2) {
                this.quality = this.quality - 2;
            }
        } else {
            if (this.quality >= 1) {
                this.quality = this.quality - 1;
            }
        }

        this.sellIn -= 1;
    }
}
