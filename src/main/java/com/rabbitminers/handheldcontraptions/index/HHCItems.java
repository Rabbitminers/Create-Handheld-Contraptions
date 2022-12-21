package com.rabbitminers.handheldcontraptions.index;

import com.rabbitminers.handheldcontraptions.HandHeldContraptions;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;

public class HHCItems {
    private static final CreateRegistrate REGISTRATE = HandHeldContraptions.registrate()
            .creativeModeTab(() -> HandHeldContraptions.itemGroup);

    // See create git for how to register items
    // - https://github.com/Creators-of-Create/Create/blob/mc1.18/dev/src/main/java/com/simibubi/create/AllItems.java
    public static void register(IEventBus eventBus) {

    }
}
