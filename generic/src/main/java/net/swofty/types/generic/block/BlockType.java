package net.swofty.types.generic.block;

import net.swofty.types.generic.block.blocks.BlockChest;
import net.swofty.types.generic.block.impl.CustomSkyBlockBlock;

public enum BlockType {
    CHEST(BlockChest.class),
    ;

    public final Class<? extends CustomSkyBlockBlock> clazz;

    BlockType(Class<? extends CustomSkyBlockBlock> clazz) {
        this.clazz = clazz;
    }
}
