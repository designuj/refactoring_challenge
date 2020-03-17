package com.zed.gildedrose.strategies;

import com.zed.gildedrose.Item;

/**
 * created by designuj on 17/03/2020
 */

public class ConjuredUpdate implements UpdateStrategy {

    @Override
    public void update(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
}
