package com.rabbitminers.handheldcontraptions.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class HHCConfig {
    public static final HHCConfig.General GENERAL;
    public static final ForgeConfigSpec spec;

    static {
        final Pair<General, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(HHCConfig.General::new);
        spec = specPair.getRight();
        GENERAL = specPair.getLeft();
    }

    public static class General {
        public ForgeConfigSpec.IntValue windmillMaxStressOutput;
        public ForgeConfigSpec.IntValue handCrankMaxStressOutput;
        public ForgeConfigSpec.IntValue furnaceEngineMaxStressOutput;
        public ForgeConfigSpec.IntValue steamEngineMaxStressOutput;
        public ForgeConfigSpec.IntValue pressureTankMaxStressOutput;
        public ForgeConfigSpec.IntValue blazeBurnerStressConsumption;
        General(ForgeConfigSpec.Builder builder) {
            builder.comment("Generator Configurations")
                    .push("Generators");

            windmillMaxStressOutput = builder
                    .comment("Maximum stress output of Windmill Generator")
                    .defineInRange("windmillMaxStressOutput", 312,1, Integer.MAX_VALUE);

            builder.pop();

            builder.comment("Modifier Component Configurations")
                    .push("Modifier Components");

            blazeBurnerStressConsumption = builder
                    .comment("Stress consumption of blaze burner")
                    .defineInRange("blazeburnerStressConsumption", 36, 1, Integer.MAX_VALUE);
        }
    }
}
