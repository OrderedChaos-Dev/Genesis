package genesis.init;

import java.util.ArrayList;
import java.util.List;

import genesis.Genesis;
import genesis.init.biomes.LakelandsBiome;
import genesis.init.biomes.LushSwampBiome;
import genesis.init.biomes.ShatteredJungleBiome;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Genesis.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class GenesisBiomes {

	public static final List<Biome> BIOMES = new ArrayList<Biome>();
	
	public static Biome lush_swamp = register(LushSwampBiome.makeLushSwampBiome(), "lush_swamp");
	public static Biome shattered_jungle = register(ShatteredJungleBiome.makeShatteredJungleBiome(), "shattered_jungle");
	public static Biome mountainous_taiga = register(BiomeMaker.makeGiantTaigaBiome(0.5F, 1.0F, 0.3F, true), "mountainous_taiga");
	public static Biome lakelands = register(LakelandsBiome.makeLakelandsBiome(), "lakelands");
	
	public static class Keys {
		public static final RegistryKey<Biome> LUSH_SWAMP = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Genesis.MOD_ID, "lush_swamp"));
		public static final RegistryKey<Biome> SHATTERED_JUNGLE = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Genesis.MOD_ID, "shattered_jungle"));
		public static final RegistryKey<Biome> MOUNTAINOUS_TAIGA = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Genesis.MOD_ID, "mountainous_taiga"));
		public static final RegistryKey<Biome> LAKELANDS = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Genesis.MOD_ID, "lakelands"));
	}
	
	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		BIOMES.forEach((biome) -> event.getRegistry().register(biome));
		
		addBiomes();
		addTypes();
	}
	
	public static Biome register(Biome biome, String name) {
		biome.setRegistryName(new ResourceLocation(Genesis.MOD_ID, name));
		BIOMES.add(biome);
		return biome;
	}
	
	public static void addBiomes() {
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.LUSH_SWAMP, 1));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Keys.SHATTERED_JUNGLE, 1));
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.MOUNTAINOUS_TAIGA, 1));
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Keys.LAKELANDS, 1));
	}
	
	public static void addTypes() {
		BiomeDictionary.addTypes(Keys.LUSH_SWAMP, Type.WET, Type.SWAMP, Type.DENSE, Type.JUNGLE, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.SHATTERED_JUNGLE, Type.HOT, Type.WET, Type.DENSE, Type.JUNGLE, Type.MOUNTAIN, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.MOUNTAINOUS_TAIGA, Type.DENSE, Type.FOREST, Type.MOUNTAIN, Type.CONIFEROUS, Type.COLD, Type.OVERWORLD);
		BiomeDictionary.addTypes(Keys.LAKELANDS, Type.COLD, Type.CONIFEROUS, Type.WET, Type.OVERWORLD);
	}
}
