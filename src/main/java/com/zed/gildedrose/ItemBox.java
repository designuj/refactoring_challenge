package com.zed.gildedrose;

import static com.zed.gildedrose.GildedRose.SULFURAS;

/**
 * created by designuj on 18/03/2020
 */

public class ItemBox {
    private Item item;

    Item openForNextDay() {
        if (!getItem().name.equals(SULFURAS)) {
            getItem().sellIn--;
        }
        return getItem();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
