package com.rabbitminers.handheldcontraptions.index;

import com.rabbitminers.handheldcontraptions.HandHeldContraptions;
import com.rabbitminers.handheldcontraptions.blocks.draftingtable.DraftingTableTileEntity;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class HHCTileEntities {
    private static final CreateRegistrate REGISTRATE = HandHeldContraptions.registrate();

    public static final BlockEntityEntry<DraftingTableTileEntity> DRAFTING_TABLE = REGISTRATE
            .tileEntity("drafting_table", DraftingTableTileEntity::new)
            .validBlocks(HHCBlocks.DRAFTING_TABLE)
            .register();
    public static void register() {}
}
