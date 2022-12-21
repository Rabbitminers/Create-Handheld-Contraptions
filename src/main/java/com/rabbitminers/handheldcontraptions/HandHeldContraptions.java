package com.rabbitminers.handheldcontraptions;

import com.mojang.logging.LogUtils;
import com.rabbitminers.handheldcontraptions.config.HHCConfig;
import com.rabbitminers.handheldcontraptions.index.HHCBlocks;
import com.rabbitminers.handheldcontraptions.index.HHCItems;
import com.rabbitminers.handheldcontraptions.index.HHCTileEntities;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HandHeldContraptions.MODID)
public class HandHeldContraptions {
    public static final String MODID = "handheldcontraptions";
    private static final NonNullSupplier<CreateRegistrate> registrate = CreateRegistrate.lazy(HandHeldContraptions.MODID);
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // TODO: Add new icon for your mod's item group
    public static final CreativeModeTab itemGroup = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AllBlocks.FLYWHEEL.get());
        }
    };

    public HandHeldContraptions()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, HHCConfig.spec);

        HHCBlocks.register();
        HHCItems.register(eventBus);
        HHCTileEntities.register();
    }

    private void setup(final FMLCommonSetupEvent event) {}

    public static CreateRegistrate registrate() {
        return registrate.get();
    }
}
