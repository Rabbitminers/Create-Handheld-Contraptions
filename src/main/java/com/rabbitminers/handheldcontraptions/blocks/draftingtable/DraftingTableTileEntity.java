package com.rabbitminers.handheldcontraptions.blocks.draftingtable;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.components.motor.CreativeMotorTileEntity;
import com.simibubi.create.content.contraptions.components.structureMovement.bearing.WindmillBearingTileEntity;
import com.simibubi.create.content.contraptions.relays.advanced.SpeedControllerBlock;
import com.simibubi.create.foundation.config.AllConfigs;
import com.simibubi.create.foundation.tileEntity.SmartTileEntity;
import com.simibubi.create.foundation.tileEntity.TileEntityBehaviour;
import com.simibubi.create.foundation.tileEntity.behaviour.ValueBoxTransform;
import com.simibubi.create.foundation.tileEntity.behaviour.scrollvalue.ScrollValueBehaviour;
import com.simibubi.create.foundation.utility.Lang;
import com.simibubi.create.foundation.utility.VecHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class DraftingTableTileEntity extends SmartTileEntity {

    public static final int DEFAULT_SPEED = 16;
    protected ScrollValueBehaviour targetSpeed;
    public DraftingTableTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<TileEntityBehaviour> behaviours) {
        Integer max = AllConfigs.SERVER.kinetics.maxRotationSpeed.get();
        targetSpeed =
                new ScrollValueBehaviour(Lang.translateDirect("generic.speed"), this, new ControllerValueBoxTransform());
        targetSpeed.between(-max, max);
        targetSpeed.value = DEFAULT_SPEED;
        targetSpeed.moveText(new Vec3(9, 0, 10));
        targetSpeed.withUnit(i -> Lang.translateDirect("generic.unit.rpm"));
        targetSpeed.withCallback(i -> this.updateTargetRotation());
        targetSpeed.withStepFunction(CreativeMotorTileEntity::step);
        behaviours.add(targetSpeed);
    }

    private void updateTargetRotation() {

    }
    private class ControllerValueBoxTransform extends ValueBoxTransform.Sided {

        @Override
        protected Vec3 getSouthLocation() {
            return VecHelper.voxelSpace(8, 11f, 16);
        }

        @Override
        protected float getScale() {
            return 0.275f;
        }

    }

}
