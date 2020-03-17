package com.zed.gildedrose.strategies;

import com.zed.gildedrose.Item;

/**
 * created by designuj on 17/03/2020
 */

public class BackstagePassesToAConcertUpdate implements UpdateStrategy {

    @Override
    public void update(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            incrementQuality(item);
            if (item.sellIn < 10) incrementQuality(item);
            if (item.sellIn < 5) incrementQuality(item);
        }
    }
}
