package net.swofty.types.generic.item.items.armor.rosetta;

import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.CustomDisplayName;
import net.swofty.types.generic.item.impl.CustomSkyBlockItem;
import net.swofty.types.generic.item.impl.Sellable;
import net.swofty.types.generic.item.impl.StandardItem;
import net.swofty.types.generic.user.statistics.ItemStatistic;
import net.swofty.types.generic.user.statistics.ItemStatistics;

public class RosettaBoots implements CustomSkyBlockItem, CustomDisplayName, StandardItem, Sellable {
    @Override
    public String getDisplayName(SkyBlockItem item) {
        return "Rosetta's Boots";
    }

    @Override
    public double getSellValue() {
        return 480;
    }

    @Override
    public StandardItemType getStandardItemType() {
        return StandardItemType.BOOTS;
    }

    @Override
    public ItemStatistics getStatistics(SkyBlockItem instance) {
        return ItemStatistics.builder()
                .withAdditive(ItemStatistic.HEALTH, 15D)
                .withAdditive(ItemStatistic.DEFENSE, 20D)
                .build();
    }
}
