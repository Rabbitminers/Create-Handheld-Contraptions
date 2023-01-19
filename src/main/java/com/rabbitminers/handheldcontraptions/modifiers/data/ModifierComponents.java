package com.rabbitminers.handheldcontraptions.modifiers.data;

import com.rabbitminers.handheldcontraptions.modifiers.*;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public enum ModifierComponents {
    INVALID_COMPONENT(0, "Invalid Component", AllItems.WRENCH.get(), 0, "Hello world", new InvalidComponent()),
    BLAZE_BURNER(0, "Blaze Burner", AllItems.EMPTY_BLAZE_BURNER.get(), 32, "Hello world", new BlazeBurnerComponent()),
    BRASS_FILTER(1, "Crushing Wheel", AllItems.ATTRIBUTE_FILTER.get(), 16, "Hello world", new BrassFilterComponent()),
    MILL_STONE(2, "Mill Stone", AllBlocks.MILLSTONE.get().asItem(), 16, "Hello world", new MillstoneComponent()),
    ANDESITE_FILTER(3, "Andesite Filter", AllItems.FILTER.get(), 16, "Hello world", new AndesiteFilterComponent()),
    EXTENDO_GRIP(4, "Extend-o-Grip", AllItems.EXTENDO_GRIP.get(), 16, "Hello world", new ExtendoGripComponent()),
    ROTATIONAL_SPEED_CONTROLLER(5, "Rotational Speed Controller", AllBlocks.ROTATION_SPEED_CONTROLLER.get().asItem(), 32, "Hello world", new RotationalSpeedControllerComponent()),
    MECHANICAL_ARM(6, "Mechanical Arm", AllBlocks.MECHANICAL_ARM.get().asItem(), 48, "Hello world", new MechanicalArmComponent()),
    SPYGLASS(7, "Spyglass", Items.SPYGLASS.asItem(), 16, "Hello world!", new SpyGlassComponent()),
    FLYWHEEL(8, "Flywheel", AllBlocks.FLYWHEEL.get().asItem(), 0, "Hello world!", new FlywheelComponent()),
    CLOCK(9, "Clock", Items.CLOCK.asItem(), 16 ,"Hello world!", new ClockComponent()),
    ELECTRON_TUBE(10, "Electron Tube", AllItems.ELECTRON_TUBE.get(), 24, "Hello world!", new ElectronTubeComponent()),
    ENCASED_FAN(11, "Encased Fan", AllBlocks.ENCASED_FAN.get().asItem(), 32, "Hello world!", new EncasedFanComponent()),
    COMPASS(12, "Compass", Items.COMPASS.asItem(), 16, "Hello world!", new CompassComponent());

    private final int id;
    private final String name;
    private final Item item;
    private final int SUconsumption;
    private final String description;
    private IModifierComponent component;

    ModifierComponents(int id, String name, Item item, int SUconsumption, String description, IModifierComponent component) {
        this.id = id;
        this.name = name;
        this.item = item;
        this.SUconsumption = SUconsumption;
        this.description = description;
        this.component = component;
    }

    public static ModifierComponents of(Item item) {
        for (ModifierComponents component : ModifierComponents.values()) {
            if (component.item == item)
                return component;
        }
        return null;
    }

    public static ModifierComponents of(int id) {
        for (ModifierComponents component : ModifierComponents.values()) {
            if (component.id == id)
                return component;
        }
        return null;
    }

    public static ModifierComponents of(String name) {
        for (ModifierComponents component : ModifierComponents.values()) {
            if (component.name == name)
                return component;
        }
        return null;
    }

    public boolean isValidComponent(Item item) {
        for (ModifierComponents component : ModifierComponents.values()) {
            if (component.item == item)
                return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
    public Item getItem() {
        return item;
    }
    public int getSUconsumption() {
        return SUconsumption;
    }
    public int getId() { return id; }
    public String getDescription() {
        return description;
    }
    public IModifierComponent getModifierComponentClass() {
        return component;
    }

}
