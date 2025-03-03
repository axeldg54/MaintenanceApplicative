package com.gildedrose;

import com.gildedrose.Item.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void expiration_date_should_decrease_quality_twice_as_fast() {
        ItemInterface[] items = new ItemInterface[]{new NormalItem("foo", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        NormalItem item = (NormalItem) app.items[0];
        assertEquals(18, item.quality, "Quality should decrease twice as fast after expiration date");
        assertEquals(-2, item.sellIn, "Expiration date should decrease by 1");
    }


    @Test
    void agedbrie_should_increase_by_1_quality() {
        ItemInterface[] items = new ItemInterface[]{new AgedBrieItem("Aged Brie", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        AgedBrieItem item = (AgedBrieItem) app.items[0];
        assertEquals(21, item.quality, "Quality should increase by 1");
        assertEquals(9, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void sulfuras_should_not_change() {
        ItemInterface[] items = new ItemInterface[]{new LegendaryItem("Sulfuras, Hand of Ragnaros", 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        LegendaryItem item = (LegendaryItem) app.items[0];
        assertEquals(80, item.quality, "Quality should not change and always be 80");
        assertEquals(10, item.sellIn, "Expiration date should not change");
    }

    @Test
    void backstage_passes_should_increase_by_1_quality_when_sellin_is_more_than_10() {
        ItemInterface[] items = new ItemInterface[]{new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        BackstagePassesItem item = (BackstagePassesItem) app.items[0];
        assertEquals(21, item.quality, "Quality should increase by 1");
        assertEquals(14, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void backstage_passes_should_increase_by_2_quality_when_sellin_is_10_or_less() {
        ItemInterface[] items = new ItemInterface[]{new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        BackstagePassesItem item = (BackstagePassesItem) app.items[0];
        assertEquals(22, item.quality, "Quality should increase by 2");
        assertEquals(9, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void backstage_passes_should_increase_by_3_quality_when_sellin_is_5_or_less() {
        ItemInterface[] items = new ItemInterface[]{new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        BackstagePassesItem item = (BackstagePassesItem) app.items[0];
        assertEquals(23, item.quality, "Quality should increase by 3");
        assertEquals(4, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void backstage_passes_should_have_0_quality_when_sellin_is_0_or_less() {
        ItemInterface[] items = new ItemInterface[]{new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        BackstagePassesItem item = (BackstagePassesItem) app.items[0];
        assertEquals(0, item.quality, "Quality should be 0");
        assertEquals(-1, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void agedbrie_quality_should_never_be_more_than_50() {
        ItemInterface[] items = new ItemInterface[]{new AgedBrieItem("Aged Brie", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        AgedBrieItem item = (AgedBrieItem) app.items[0];
        assertEquals(50, item.quality, "Quality should never be more than 50");
        assertEquals(9, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void backstages_passes_quality_should_never_be_more_than_50() {
        ItemInterface[] items = new ItemInterface[]{new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        BackstagePassesItem item = (BackstagePassesItem) app.items[0];
        assertEquals(50, item.quality, "Quality should never be more than 50");
        assertEquals(9, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void quality_should_never_be_negative() {
        ItemInterface[] items = new ItemInterface[]{new NormalItem("foo", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        NormalItem item = (NormalItem) app.items[0];
        assertEquals(0, item.quality, "Quality should never be negative");
        assertEquals(9, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void quality_should_decrease_by_1() {
        ItemInterface[] items = new ItemInterface[]{new NormalItem("foo", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        NormalItem item = (NormalItem) app.items[0];
        assertEquals(19, item.quality, "Quality should decrease by 1");
        assertEquals(9, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void quality_should_decrease_by_2_after_expiration_date() {
        ItemInterface[] items = new ItemInterface[]{new NormalItem("foo", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        NormalItem item = (NormalItem) app.items[0];
        assertEquals(18, item.quality, "Quality should decrease by 2 after expiration date");
        assertEquals(-2, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void quality_should_never_be_more_than_50_after_expiration_date() {
        ItemInterface[] items = new ItemInterface[]{new AgedBrieItem("Aged Brie", -1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        AgedBrieItem item = (AgedBrieItem) app.items[0];
        assertEquals(50, item.quality, "Quality should never be more than 50 after expiration date");
        assertEquals(-2, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void quality_should_never_be_negative_after_expiration_date() {
        ItemInterface[] items = new ItemInterface[]{new NormalItem("foo", -1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        NormalItem item = (NormalItem) app.items[0];
        assertEquals(0, item.quality, "Quality should never be negative after expiration date");
        assertEquals(-2, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void conjured_items_should_decrease_quality_twice_as_fast() {
        ItemInterface[] items = new ItemInterface[]{new ConjuredItem("Conjured blabla", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        ConjuredItem item = (ConjuredItem) app.items[0];
        assertEquals(18, item.quality, "Quality should decrease by 2");
        assertEquals(9, item.sellIn, "Expiration date should decrease by 1");
    }

    @Test
    void conjured_items_should_decrease_quality_twice_as_fast_after_expiration_date() {
        ItemInterface[] items = new ItemInterface[]{new ConjuredItem("Conjured boubou", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        ConjuredItem item = (ConjuredItem) app.items[0];
        assertEquals(16, item.quality, "Quality should decrease by 4 after expiration date");
        assertEquals(-2, item.sellIn, "Expiration date should decrease by 1");
    }
}
