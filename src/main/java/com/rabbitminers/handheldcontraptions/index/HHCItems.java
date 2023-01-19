package com.rabbitminers.handheldcontraptions.index;

import com.rabbitminers.handheldcontraptions.HandHeldContraptions;
import com.rabbitminers.handheldcontraptions.tools.DrillTool;
import com.rabbitminers.handheldcontraptions.tools.ToolBase;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraftforge.eventbus.api.IEventBus;

public class HHCItems {
    private static final CreateRegistrate REGISTRATE = HandHeldContraptions.registrate()
            .creativeModeTab(() -> HandHeldContraptions.itemGroup);

    public static final ItemEntry<DrillTool> DRILL_TOOL =
            REGISTRATE.item("drill_tool", DrillTool::new)
                    .properties(p -> p.stacksTo(1))
                    .lang("Drill Tool")
                    .register();

    public static void register(IEventBus eventBus) {}
}
