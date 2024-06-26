package net.swofty.types.generic.item.items.armor.farmsuit;

import net.minestom.server.color.Color;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.*;
import net.swofty.types.generic.user.statistics.ItemStatistic;
import net.swofty.types.generic.user.statistics.ItemStatistics;


public class FarmSuitBoots implements CustomSkyBlockItem, StandardItem, LeatherColour, Sellable, NotFinishedYet {

    @Override
    public Color getLeatherColour() {
        return new Color(255, 255, 0);
    }

    @Override
    public double getSellValue() {
        return 20;
    }

    @Override
    public StandardItemType getStandardItemType() {
        return StandardItemType.BOOTS;
    }

    @Override
    public ItemStatistics getStatistics(SkyBlockItem instance) {
        return ItemStatistics.builder()
                .withAdditive(ItemStatistic.DEFENSE, 15D)
                .withAdditive(ItemStatistic.FARMING_FORTUNE, 5D)
                .build();
    }
}
