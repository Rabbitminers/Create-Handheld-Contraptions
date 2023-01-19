package com.rabbitminers.handheldcontraptions.index;

import com.rabbitminers.handheldcontraptions.HandHeldContraptions;
import com.rabbitminers.handheldcontraptions.blocks.draftingtable.DraftingTableBlock;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.contraptions.relays.advanced.SpeedControllerBlock;
import com.simibubi.create.foundation.data.*;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.material.MaterialColor;

public class HHCBlocks {
    private static final CreateRegistrate REGISTRATE = HandHeldContraptions.registrate().creativeModeTab(
            () -> HandHeldContraptions.itemGroup
    );

    public static final BlockEntry<DraftingTableBlock> DRAFTING_TABLE =
            REGISTRATE.block("drafting_table", DraftingTableBlock::new)
                    .initialProperties(SharedProperties::wooden)
                    .properties(p -> p.color(MaterialColor.COLOR_BROWN))
                    .blockstate(BlockStateGen.horizontalAxisBlockProvider(true))
                    .item()
                    .transform(ModelGen.customItemModel())
                    .register();

    // See create git for how to register blocks
    // - https://github.com/Creators-of-Create/Create/blob/mc1.18/dev/src/main/java/com/simibubi/create/AllBlocks.java

    public static void register() {}
}
