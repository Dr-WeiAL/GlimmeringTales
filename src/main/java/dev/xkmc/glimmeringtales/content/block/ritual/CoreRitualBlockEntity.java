package dev.xkmc.glimmeringtales.content.block.ritual;

import dev.xkmc.l2modularblock.tile_api.TickableBlockEntity;
import dev.xkmc.l2serial.serialization.marker.SerialClass;
import dev.xkmc.l2serial.serialization.marker.SerialField;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.LinkedHashSet;

@SerialClass
public class CoreRitualBlockEntity extends BaseRitualBlockEntity implements TickableBlockEntity {

	@SerialField
	private final LinkedHashSet<BlockPos> linked = new LinkedHashSet<>();

	public CoreRitualBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	@Override
	public void tick() {
		recheckPos();
	}

	private void recheckPos() {
		if (level == null || level.isClientSide()) return;
		if (level.getGameTime() % PerformanceConstants.CHECK_INTERVAL != 0) return;
		var pos = getBlockPos();
		if (linked.removeIf(e -> !(level.getBlockEntity(e) instanceof SideRitualBlockEntity be && be.isLinked(this, pos)))) {
			sync();
			setChanged();
		}
	}

	public boolean isLinked(SideRitualBlockEntity side, BlockPos pos) {
		return linked.contains(pos);
	}

	public void removeLink(SideRitualBlockEntity side, BlockPos pos) {
		if (!linked.remove(pos)) return;
		sync();
		setChanged();
	}

	@Override
	public void onReplaced() {
		if (level == null || level.isClientSide()) return;
		for (var e : linked) {
			if (level.getBlockEntity(e) instanceof SideRitualBlockEntity be) {
				be.removeLink(this, getBlockPos());
			}
		}
	}

	@Override
	public void onPlaced() {
		if (level == null || level.isClientSide()) return;
		linked.clear();
		int r = PerformanceConstants.RANGE;
		BlockPos self = getBlockPos();
		for (int x = -r; x <= r; x++) {
			for (int y = -r; y <= r; y++) {
				for (int z = -r; z <= r; z++) {
					BlockPos pos = self.offset(x, y, z);
					if (level.getBlockEntity(pos) instanceof SideRitualBlockEntity be) {
						var other = be.getLink();
						if (other == null || other.distSqr(pos) < self.distSqr(pos)) {
							be.establishLink(this, self);
							linked.add(pos);
						}
					}
				}
			}
		}
		sync();
		setChanged();
	}

}
