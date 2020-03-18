package com.zed.gildedrose.strategies;

import com.zed.gildedrose.Item;

/**
 * created by designuj on 17/03/2020
 */

public class BackstagePassesToAConcertUpdate implements UpdateStrategy {

    @Override
    public void updateItem(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            changeQuality(item, 1, false);
            if (item.sellIn < 10) changeQuality(item, 1, false);
            if (item.sellIn < 5) changeQuality(item, 1, false);
        }
    }
}
