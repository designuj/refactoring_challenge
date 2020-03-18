package com.zed.gildedrose.strategies;

import com.zed.gildedrose.Item;

/**
 * created by designuj on 17/03/2020
 */

public class SimpleUpdate implements UpdateStrategy {
    private SimpleType simpleType;

    public SimpleUpdate(SimpleType simpleType) {
        this.simpleType = simpleType;
    }

    @Override
    public void updateItem(Item item) {
        switch (simpleType) {
            case CHOOSE_DEFAULT:
                changeQuality(item, 1, true);
                break;
            case CHOOSE_CONJURED:
                changeQuality(item, 2, true);
                break;
            case CHOOSE_AGED_BRIE:
                changeQuality(item, 1, false);
                break;
        }
    }
}
