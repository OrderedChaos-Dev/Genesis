package genesis.init.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class LushSwampBiome {
	
	public static Biome makeLushSwampBiome() {	
		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244189_u);
		
		BiomeUtils.withBasicFeatures(biomeGenSettings);
		BiomeUtils.withBasicMobs(mobSpawnInfo);
		BiomeUtils.withBasicStructures(biomeGenSettings);
		
		mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 1, 1, 1));

		biomeGenSettings.withStructure(StructureFeatures.RUINED_PORTAL_SWAMP);
		biomeGenSettings.withStructure(StructureFeatures.SWAMP_HUT);
		
		DefaultBiomeFeatures.withSwampVegetation(biomeGenSettings);
		DefaultBiomeFeatures.withSwampSugarcaneAndPumpkin(biomeGenSettings);
		DefaultBiomeFeatures.withJungleEdgeTrees(biomeGenSettings);
		DefaultBiomeFeatures.withJungleGrass(biomeGenSettings);
		DefaultBiomeFeatures.withMelonPatchesAndVines(biomeGenSettings);
		DefaultBiomeFeatures.withFossils(biomeGenSettings);
		DefaultBiomeFeatures.withBambooVegetation(biomeGenSettings);
		DefaultBiomeFeatures.withWarmFlowers(biomeGenSettings);
		biomeGenSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.MUSHROOM_FIELD_VEGETATION);
		biomeGenSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_SWAMP);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.SWAMP).depth(-0.2F)
				.scale(0.1F).temperature(0.9F).downfall(0.9F)
				.setEffects((new BiomeAmbience.Builder()).setWaterColor(6388580).setWaterFogColor(2302743)
						.setFogColor(12638463).withSkyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.8F))
						.setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
				.withMobSpawnSettings(mobSpawnInfo.copy())
				.withGenerationSettings(biomeGenSettings.build()).build();
	}
}
