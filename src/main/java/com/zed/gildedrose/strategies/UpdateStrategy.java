package com.zed.gildedrose.strategies;

import com.zed.gildedrose.Item;

import static com.zed.gildedrose.GildedRose.MAX_QUALITY;

/**
 * created by designuj on 18/03/2020
 */

public interface UpdateStrategy {
    void updateItem(Item item);

    default void changeQuality(Item item, Integer times, Boolean decrement) {
        if (decrement) {
            for (int i = 0; i < times; i++) {
                if (item.quality > 0) {
                    item.quality--;
                    if (item.quality > 0 && item.sellIn < 0) {
                        item.quality--;
                    }
                }
            }
        } else {
            for (int i = 0; i < times; i++) {
                if (item.quality < MAX_QUALITY) {
                    item.quality++;
                    if (item.quality < MAX_QUALITY && item.sellIn < 0) {
                        item.quality++;
                    }
                }
            }
        }
    }
}
