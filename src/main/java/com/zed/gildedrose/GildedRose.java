package com.zed.gildedrose;

import com.zed.gildedrose.strategies.*;

import static com.zed.gildedrose.strategies.SimpleType.*;

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

            //create new strategy
            UpdateStrategy updateStrategy;

            //get it covered
            ItemBox itemBox = new ItemBox();

            //put item to box
            itemBox.setItem(item);

            //where should I go?
            switch (itemName) {
                case SULFURAS:
                    updateStrategy = new SulfrasUpdate();
                    break;
                case BACKSTAGE_PASSES_TO_CONCERT:
                    updateStrategy = new BackstagePassesToAConcertUpdate();
                    break;
                case AGED_BRIE:
                    updateStrategy = new SimpleUpdate(CHOOSE_AGED_BRIE);
                    break;
                case CONJURED:
                    updateStrategy = new SimpleUpdate(CHOOSE_CONJURED);
                    break;
                default:
                    updateStrategy = new SimpleUpdate(CHOOSE_DEFAULT);
            }

            updateStrategy.updateItem(itemBox.openForNextDay());
        }
    }
}
