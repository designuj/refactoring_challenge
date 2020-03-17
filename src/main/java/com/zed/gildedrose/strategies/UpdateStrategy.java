package com.zed.gildedrose.strategies;

import com.zed.gildedrose.Item;

import static com.zed.gildedrose.GildedRose.MAX_QUALITY;
import static com.zed.gildedrose.GildedRose.SULFURAS;

public interface UpdateStrategy {

    void update(Item item);

    default void dayGone(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn--;
        }
    }

    default void  incrementQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
            if (item.quality < MAX_QUALITY && item.sellIn < 0) {
                item.quality++;
            }
        }
    }

    default void decrementQuality(Item item) {
        if(item.quality > 0) {
            item.quality--;
            if (item.quality > 0 && item.sellIn < 0) {
                item.quality--;
            }
        }
    }
}
