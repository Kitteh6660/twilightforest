package twilightforest.world.components.structures.trollcave;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import twilightforest.world.registration.TFFeature;
import twilightforest.block.TFBlocks;
import twilightforest.world.components.structures.TFStructureComponentOld;

import java.util.Random;

public class CloudTreeComponent extends TFStructureComponentOld {

	public CloudTreeComponent(ServerLevel level, CompoundTag nbt) {
		super(TrollCavePieces.TFClTr, nbt);
	}

	public CloudTreeComponent(TFFeature feature, int index, int x, int y, int z) {
		super(TrollCavePieces.TFClTr, feature, index, x, y, z);

		this.setOrientation(Direction.SOUTH);

		// adjust x, y, z
		x = (x >> 2) << 2;
		y = (y >> 2) << 2;
		z = (z >> 2) << 2;

		this.boundingBox = feature.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 20, 28, 20, Direction.SOUTH);

		// spawn list!
		this.spawnListIndex = 1;
	}

	@Override
	public boolean postProcess(WorldGenLevel world, StructureFeatureManager manager, ChunkGenerator generator, Random rand, BoundingBox sbb, ChunkPos chunkPosIn, BlockPos blockPos) {

		// leaves
		this.generateBox(world, sbb, 0, 12, 0, 19, 19, 19, TFBlocks.GIANT_LEAVES.get().defaultBlockState(), TFBlocks.GIANT_LEAVES.get().defaultBlockState(), false);
		this.generateBox(world, sbb, 4, 20, 4, 15, 23, 15, TFBlocks.GIANT_LEAVES.get().defaultBlockState(), TFBlocks.GIANT_LEAVES.get().defaultBlockState(), false);
		this.generateBox(world, sbb, 8, 24, 4, 11, 27, 15, TFBlocks.GIANT_LEAVES.get().defaultBlockState(), TFBlocks.GIANT_LEAVES.get().defaultBlockState(), false);
		this.generateBox(world, sbb, 4, 24, 8, 15, 27, 11, TFBlocks.GIANT_LEAVES.get().defaultBlockState(), TFBlocks.GIANT_LEAVES.get().defaultBlockState(), false);

		// trunk
		this.generateBox(world, sbb, 8, 0, 8, 11, 23, 11, TFBlocks.GIANT_LOG.get().defaultBlockState(), TFBlocks.GIANT_LOG.get().defaultBlockState(), false);

		// cloud base
		this.generateBox(world, sbb, 8, -4, 8, 11, -1, 11, TFBlocks.FLUFFY_CLOUD.get().defaultBlockState(), TFBlocks.FLUFFY_CLOUD.get().defaultBlockState(), false);

		return true;
	}
}
