package com.rabbitminers.handheldcontraptions.blocks.draftingtable;

import com.rabbitminers.handheldcontraptions.index.HHCTileEntities;
import com.simibubi.create.content.contraptions.processing.BasinBlock;
import com.simibubi.create.foundation.block.ITE;
import com.simibubi.create.foundation.tileEntity.behaviour.scrollvalue.ScrollValueBehaviour;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class DraftingTableBlock extends HorizontalDirectionalBlock implements ITE<DraftingTableTileEntity> {

    public DraftingTableBlock(Properties p_54120_) {
        super(p_54120_);
    }
    @Override
    public Class<DraftingTableTileEntity> getTileEntityClass() {
        return DraftingTableTileEntity.class;
    }
    @Override
    public BlockEntityType<? extends DraftingTableTileEntity> getTileEntityType() {
        return HHCTileEntities.DRAFTING_TABLE.get();
    }
}
