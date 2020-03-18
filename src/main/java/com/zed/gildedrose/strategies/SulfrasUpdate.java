package com.zed.gildedrose.strategies;

import com.zed.gildedrose.Item;

import java.util.Optional;

import static com.zed.gildedrose.GildedRose.SULFURAS_QUALITY;

/**
 * created by designuj on 17/03/2020
 */

public class SulfrasUpdate implements UpdateStrategy {

    @Override
    public void updateItem(Item item) {
        Optional.of(item)
                .filter(s -> s.quality == SULFURAS_QUALITY)
                .orElseThrow(IllegalArgumentException::new);
    }
}
