package genesis.init.biomes;

import genesis.init.GenesisFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class LakelandsBiome {

	public static Biome makeLakelandsBiome() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder())
				.withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);
		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();

		BiomeUtils.withBasicFeatures(biomeGenSettings);
		BiomeUtils.withBasicMobs(mobSpawnInfo);
		BiomeUtils.withBasicStructures(biomeGenSettings);
		mobSpawnInfo.isValidSpawnBiomeForPlayer();

		biomeGenSettings.withStructure(StructureFeatures.RUINED_PORTAL);

		DefaultBiomeFeatures.withLargeFern(biomeGenSettings);
		DefaultBiomeFeatures.withTaigaVegetation(biomeGenSettings);
		DefaultBiomeFeatures.withDefaultFlowers(biomeGenSettings);
		DefaultBiomeFeatures.withTaigaGrassVegetation(biomeGenSettings);
		DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomeGenSettings);
		DefaultBiomeFeatures.withSparseBerries(biomeGenSettings);
		biomeGenSettings.withFeature(Decoration.LAKES, GenesisFeatures.MANY_LAKES);
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.TAIGA).depth(-0.2F).scale(0.005F).temperature(0.25F)
				.downfall(0.8F)
				.setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204)
						.setWaterFogColor(329011).setFogColor(12638463)
						.withSkyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.25F))
						.setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
				.withMobSpawnSettings(mobSpawnInfo.copy())
				.withGenerationSettings(biomeGenSettings.build()).build();
	}
}
