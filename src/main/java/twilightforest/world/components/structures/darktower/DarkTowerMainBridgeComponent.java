package twilightforest.world.components.structures.darktower;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import twilightforest.world.registration.TFFeature;

import java.util.Random;

public class DarkTowerMainBridgeComponent extends DarkTowerBridgeComponent {

	public DarkTowerMainBridgeComponent(ServerLevel level, CompoundTag nbt) {
		super(DarkTowerPieces.TFDTMB, nbt);
	}

	protected DarkTowerMainBridgeComponent(TFFeature feature, int i, int x, int y, int z, int pSize, int pHeight, Direction direction) {
		super(DarkTowerPieces.TFDTMB, feature, i, x, y, z, 15, pHeight, direction);
	}

	@Override
	public boolean makeTowerWing(StructurePieceAccessor list, Random rand, int index, int x, int y, int z, int wingSize, int wingHeight, Rotation rotation) {
		// make another size 15 main tower
		Direction direction = getStructureRelativeRotation(rotation);
		int[] dx = offsetTowerCoords(x, y, z, 19, direction);

		DarkTowerMainComponent wing = new DarkTowerMainComponent(getFeatureType(), rand, index, dx[0], dx[1], dx[2], direction);

		list.addPiece(wing);
		wing.addChildren(this, list, rand);
		addOpening(x, y, z, rotation);
		return true;
	}
}
