package com.gildedrose.Item;

public class BackstagePassesItem extends Item implements ItemInterface {

    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (this.quality >= 50) {
            this.sellIn -= 1;
            return;
        }

        if (this.sellIn <= 0) {
            this.quality = 0;
        } else if (this.sellIn <= 5) {
            this.quality = this.quality + 3;
        } else if (this.sellIn <= 10) {
            this.quality = this.quality + 2;
        } else {
            this.quality = this.quality + 1;
        }

        this.sellIn -= 1;
    }
}
