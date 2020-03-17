package com.zed.gildedrose;

import com.zed.gildedrose.strategies.*;

public class GildedRose {
    Item[] items;

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";

    public static final int MAX_QUALITY = 50;
    public static final int SULFURAS_QUALITY = 80;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public GildedRose() {
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {
            String itemName = item.name;

            UpdateStrategy updateStrategy;

            switch (itemName) {
                case SULFURAS:
                    updateStrategy = new SulfrasUpdate();
                    break;
                case AGED_BRIE:
                    updateStrategy = new AgedBrieUpdate();
                    break;
                case BACKSTAGE_PASSES_TO_CONCERT:
                    updateStrategy = new BackstagePassesToAConcertUpdate();
                    break;
                case CONJURED:
                    updateStrategy = new ConjuredUpdate();
                    break;
                default:
                    updateStrategy = new NothingSpecialUpdate();
            }

            updateStrategy.dayGone(item);
            updateStrategy.update(item);
        }
    }
}
