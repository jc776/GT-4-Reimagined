package trinsdar.gt4r.data;

import com.google.common.collect.ImmutableMap;
import muramasa.antimatter.AntimatterConfig;
import muramasa.antimatter.cover.BaseCover;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.item.ItemBattery;
import muramasa.antimatter.item.ItemCover;
import muramasa.antimatter.item.ItemFluidCell;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.ore.StoneType;
import muramasa.antimatter.pipe.PipeSize;
import muramasa.antimatter.pipe.types.Cable;
import muramasa.antimatter.pipe.types.FluidPipe;
import muramasa.antimatter.pipe.types.Wire;
import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import muramasa.antimatter.texture.Texture;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.IAntimatterTool;
import muramasa.antimatter.util.Utils;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import trinsdar.gt4r.Ref;
import trinsdar.gt4r.block.BlockCasing;
import trinsdar.gt4r.block.BlockConnectedCasing;
import trinsdar.gt4r.block.BlockSapBag;
import trinsdar.gt4r.cover.CoverConveyor;
import trinsdar.gt4r.cover.CoverDrain;
import trinsdar.gt4r.cover.CoverDynamoOld;
import trinsdar.gt4r.cover.CoverFusionInput;
import trinsdar.gt4r.cover.CoverFusionOutput;
import trinsdar.gt4r.cover.CoverPump;
import trinsdar.gt4r.items.ItemIntCircuit;
import trinsdar.gt4r.items.MaterialSpear;
import trinsdar.gt4r.tree.BlockRubberLeaves;
import trinsdar.gt4r.tree.BlockRubberLog;
import trinsdar.gt4r.tree.BlockRubberSapling;

import java.util.function.Supplier;

import static trinsdar.gt4r.data.Materials.*;

public class GT4RData {

    private static final boolean HC = AntimatterConfig.GAMEPLAY.HARDCORE_CABLES;

    static {
        {
            ImmutableMap.Builder<Integer, RecipeIngredient> builder = ImmutableMap.builder();
            ImmutableMap.Builder<Integer, Item> builderItems = ImmutableMap.builder();
            for (int i = 0; i <= 24; i++) {
                Item circuit = new ItemIntCircuit(Ref.ID, "int_circuit_"+i, i).tip("ID: " + i);
                builder.put(i, RecipeIngredient.of(circuit, 1).setNoConsume());
                builderItems.put(i, circuit);
            }
            INT_CIRCUITS = builder.build();
            INT_CIRCUITS_ITEMS = builderItems.build();
        }
        {
            ImmutableMap.Builder<Tier, Material> builder = ImmutableMap.builder();
            builder.put(Tier.ULV, WroughtIron);
            builder.put(Tier.LV, Steel);
            builder.put(Tier.MV, Aluminium);
            builder.put(Tier.HV, StainlessSteel);
            builder.put(Tier.EV, Titanium);
            builder.put(Tier.IV, TungstenSteel);
            TIER_MATERIALS = builder.build();
        }
    }

    public static void buildTierMaps() {
        {
            ImmutableMap.Builder<Tier, Wire<?>> builder = ImmutableMap.builder();
            builder.put(Tier.ULV, WIRE_LEAD);
            builder.put(Tier.LV, WIRE_TIN);
            builder.put(Tier.MV, WIRE_COPPER);
            builder.put(Tier.HV, WIRE_GOLD);
            builder.put(Tier.EV, WIRE_ALUMINIUM);
            builder.put(Tier.IV, WIRE_TUNGSTEN);
            TIER_WIRES = builder.build();
        }
        {
            ImmutableMap.Builder<Tier, Cable<?>> builder = ImmutableMap.builder();
            builder.put(Tier.ULV, CABLE_LEAD);
            builder.put(Tier.LV, CABLE_TIN);
            builder.put(Tier.MV, CABLE_COPPER);
            builder.put(Tier.HV, CABLE_GOLD);
            builder.put(Tier.EV, CABLE_ALUMINIUM);
            builder.put(Tier.IV, CABLE_TUNGSTEN);
            TIER_CABLES = builder.build();
        }
        {
            ImmutableMap.Builder<Tier, Item> builder = ImmutableMap.builder();
            builder.put(Tier.ULV, BatteryRE);
            builder.put(Tier.LV, BatterySmallLithium);
            builder.put(Tier.MV, BatteryMediumLithium);
            builder.put(Tier.HV, BatteryLargeLithium);
            builder.put(Tier.EV, LapotronCrystal);
            builder.put(Tier.IV, LapotronicEnergyOrb);
            TIER_BATTERIES = builder.build();
        }
    }

    public static void init(Dist side) {
        if (side.isClient()){
            RecipeRenderer.clientMaps();
        }
    }

    public static final BaseCover COVER_CONVEYOR = new CoverConveyor();
    public static final BaseCover COVER_PUMP = new CoverPump();
    public static final BaseCover COVER_FUSION_OUTPUT = new CoverFusionOutput();
    public static final BaseCover COVER_FUSION_INPUT = new CoverFusionInput();
    public static final BaseCover COVER_DYNAMO_OLD = new CoverDynamoOld("dynamo_old");
    public static final BaseCover COVER_DRAIN = new CoverDrain();

    public static ItemBasic<?> StickyResin = new ItemBasic<>(Ref.ID, "sticky_resin");
    public static ItemBasic<?> Plantball = new ItemBasic<>(Ref.ID, "plantball");
    public static ItemBasic<?> Biochaff = new ItemBasic<>(Ref.ID, "biochaff");
    public static ItemBasic<?> CarbonFibre = new ItemBasic<>(Ref.ID, "raw_carbon_fibre");
    public static ItemBasic<?> CarbonMesh = new ItemBasic<>(Ref.ID, "carbon_mesh");
    public static ItemBasic<?> CoalBall = new ItemBasic<>(Ref.ID, "coal_ball");
    public static ItemBasic<?> CompressedCoalBall = new ItemBasic<>(Ref.ID, "compressed_coal_ball");
    public static ItemBasic<?> CoalChunk = new ItemBasic<>(Ref.ID, "coal_chunk");

    public static ItemBasic<?> ComputerMonitor = new ItemBasic<>(Ref.ID, "computer_monitor").tip("Can be placed on machines as a cover");
    public static ItemCover ConveyorModule = new ItemCover(Ref.ID, COVER_CONVEYOR.getId()).tip("Can be placed on machines as a cover");
    public static ItemBasic<?> CraftingModule = new ItemBasic<>(Ref.ID, "crafting_module").tip("Can be placed on machines as a cover");
    public static ItemCover Drain = new ItemCover(Ref.ID, "drain").tip("Can be placed on machines as a cover");
    public static ItemBasic<?> ItemTransportValve = new ItemBasic<>(Ref.ID, "item_transport_valve").tip("Can be placed on machines as a cover");
    public static ItemCover PumpModule = new ItemCover(Ref.ID, COVER_PUMP.getId()).tip("Can be placed on machines as a cover");
    public static ItemBasic<?> RedstoneMachineController = new ItemBasic<>(Ref.ID, "redstone_machine_controller").tip("Can be placed on machines as a cover");
    public static ItemBasic<?> Shutter = new ItemBasic<>(Ref.ID, "shutter").tip("Can be placed on machines as a cover");

    public static ItemFluidCell CellTin = new ItemFluidCell(Ref.ID,Tin, 1000);

    public static ItemBasic<?> CopperCoil = new ItemBasic<>(Ref.ID, "copper_coil");
    public static ItemBasic<?> CupronickelHeatingCoil = new ItemBasic<>(Ref.ID, "cupronickel_heating_coil");
    public static ItemBasic<?> KanthalHeatingCoil = new ItemBasic<>(Ref.ID, "kanthal_heating_coil");
    public static ItemBasic<?> NichromeHeatingCoil = new ItemBasic<>(Ref.ID, "nichrome_heating_coil");
    public static ItemBasic<?> ItemFilter = new ItemBasic<>(Ref.ID, "item_filter");
    public static ItemBasic<?> DiamondSawBlade = new ItemBasic<>(Ref.ID, "diamond_saw_blade");
    public static ItemBasic<?> DiamondGrindHead = new ItemBasic<>(Ref.ID, "diamond_grind_head");
    public static ItemBasic<?> TungstenGrindHead = new ItemBasic<>(Ref.ID, "tungsten_grind_head");
    public static ItemBasic<?> IridiumAlloyIngot = new ItemBasic<>(Ref.ID, "iridium_alloy_ingot").tip("Used to make Iridium Plates");
    public static ItemBasic<?> IridiumReinforcedPlate = new ItemBasic<>(Ref.ID, "iridium_reinforced_plate").tip("GT2s Most Expensive Component");
    public static ItemBasic<?> IridiumNeutronReflector = new ItemBasic<>(Ref.ID, "iridium_neutron_reflector").tip("Indestructible");
    public static ItemBasic<?> CompressedFireClay = new ItemBasic<>(Ref.ID, "compressed_fire_clay").tip("Brick Shaped");
    public static ItemBasic<?> FireBrick = new ItemBasic<>(Ref.ID, "fire_brick").tip("Heat Resistant");
    public static ItemBasic<?> ItemSuperconductor = new ItemBasic<>(Ref.ID, "superconductor").tip("Conducts Energy Losslessly");

    public static ItemBasic<?> LavaFilter = new ItemBasic<>(Ref.ID, "lava_filter");
    public static ItemBasic<?> Match = new ItemBasic<>(Ref.ID, "match");
    public static ItemBasic<?> MatchBook = new ItemBasic<>(Ref.ID, "match_book");
    public static ItemBasic<?> Treetap = new ItemBasic<>(Ref.ID, "treetap", new Item.Properties().defaultMaxDamage(16).group(muramasa.antimatter.Ref.TAB_ITEMS));

    public static ItemBasic<?> MixedMetal = new ItemBasic<>(Ref.ID, "mixed_metal");
    public static ItemBasic<?> AdvancedAlloy = new ItemBasic<>(Ref.ID,"advanced_alloy");
    public static ItemBasic<?> MachineParts = new ItemBasic<>(Ref.ID, "machine_parts");
    public static ItemBasic<?> AdvCircuitParts = new ItemBasic<>(Ref.ID, "advanced_circuit_parts").tip("Used for making Advanced Circuits");
    public static ItemBasic<?> CircuitBoardBasic = new ItemBasic<>(Ref.ID, "basic_circuit_board").tip("A basic Board");
    public static ItemBasic<?> CircuitBoardAdv = new ItemBasic<>(Ref.ID, "advanced_circuit_board").tip("An advanced Board");
    public static ItemBasic<?> CircuitBoardProcessor = new ItemBasic<>(Ref.ID, "processor_circuit_board").tip("A Processor Board");
    public static ItemBasic<?> CircuitBasic = new ItemBasic<>(Ref.ID, "basic_circuit").tip("A basic Circuit");
    public static ItemBasic<?> CircuitAdv = new ItemBasic<>(Ref.ID, "advanced_circuit").tip("An advanced Circuit");
    public static ItemBasic<?> CircuitDataStorage = new ItemBasic<>(Ref.ID, "data_storage_circuit").tip("A Data Storage Chip");
    public static ItemBasic<?> CircuitDataControl = new ItemBasic<>(Ref.ID, "data_control_circuit").tip("A Data Control Processor");
    public static ItemBasic<?> CircuitEnergyFlow = new ItemBasic<>(Ref.ID, "energy_flow_circuit").tip("A High Voltage Processor");
    public static ItemBasic<?> CircuitDataOrb = new ItemBasic<>(Ref.ID, "data_orb").tip("A High Capacity Data Storage");
    public static ItemBasic<?> MotorLV = new ItemBasic<>(Ref.ID, "lv_motor");
    public static ItemBasic<?> MotorMV = new ItemBasic<>(Ref.ID, "mv_motor");
    public static ItemBasic<?> MotorHV = new ItemBasic<>(Ref.ID, "hv_motor");

    public static ItemBasic<?> BatteryHullSmall = new ItemBasic<>(Ref.ID, "battery_hull_small").tip("An empty LV Battery Hull");
    public static ItemBasic<?> BatteryHullMedium = new ItemBasic<>(Ref.ID, "battery_hull_medium").tip("An empty MV Battery Hull");
    public static ItemBasic<?> BatteryHullLarge = new ItemBasic<>(Ref.ID, "battery_hull_large").tip("An empty HV Battery Hull");
    public static ItemBasic<?> BatterySmallAcid = new ItemBattery(Ref.ID, "battery_small_acid", Tier.LV, 50000, false).tip("Single Use");
    public static ItemBasic<?> BatterySmallMercury = new ItemBattery(Ref.ID, "battery_small_mercury", Tier.LV, 100000, false).tip("Single Use");
    public static ItemBasic<?> BatterySmallCadmium = new ItemBattery(Ref.ID, "battery_small_cadmium", Tier.LV,75000, true).tip("Reusable");
    public static ItemBasic<?> BatterySmallLithium = new ItemBattery(Ref.ID, "battery_small_lithium", Tier.LV, 100000, true).tip("Reusable");
    public static ItemBasic<?> BatterySmallSodium = new ItemBattery(Ref.ID, "battery_small_sodium", Tier.LV, 50000, true).tip("Reusable");
    public static ItemBasic<?> BatteryMediumAcid = new ItemBattery(Ref.ID, "battery_medium_acid", Tier.MV, 200000, false).tip("Single Use");
    public static ItemBasic<?> BatteryMediumMercury = new ItemBattery(Ref.ID, "battery_medium_mercury", Tier.MV, 400000, false).tip("Single Use");
    public static ItemBasic<?> BatteryMediumCadmium = new ItemBattery(Ref.ID, "battery_medium_cadmium", Tier.MV, 300000, true).tip("Reusable");
    public static ItemBasic<?> BatteryMediumLithium = new ItemBattery(Ref.ID, "battery_medium_lithium", Tier.MV, 400000, true).tip("Reusable");
    public static ItemBasic<?> BatteryMediumSodium = new ItemBattery(Ref.ID, "battery_medium_sodium", Tier.MV,200000, true).tip("Reusable");
    public static ItemBasic<?> BatteryLargeAcid = new ItemBattery(Ref.ID, "battery_large_acid", Tier.HV, 800000, false).tip("Single Use");
    public static ItemBasic<?> BatteryLargeMercury = new ItemBattery(Ref.ID, "battery_large_mercury", Tier.HV, 1600000, false).tip("Single Use");
    public static ItemBasic<?> BatteryLargeCadmium = new ItemBattery(Ref.ID, "battery_large_cadmium", Tier.HV, 1200000, true).tip("Reusable");
    public static ItemBasic<?> BatteryLargeLithium = new ItemBattery(Ref.ID, "battery_large_lithium", Tier.HV, 1600000, true).tip("Reusable");
    public static ItemBasic<?> BatteryLargeSodium = new ItemBattery(Ref.ID, "battery_large_sodium", Tier.HV, 800000, true).tip("Reusable");
    public static ItemBasic<?> LapotronCrystal = new ItemBattery(Ref.ID, "lapotron_crystal", Tier.EV, 10000000, true).tip("Reusable");
    public static ItemBasic<?> EnergyCrystal = new ItemBattery(Ref.ID, "energy_crystal", Tier.HV, 1000000, true).tip("Reusable");
    public static ItemBasic<?> BatteryRE = new ItemBattery(Ref.ID, "battery_re", Tier.LV, 10000, true).tip("Reusable");
    public static ItemBasic<?> LapotronicEnergyOrb = new ItemBattery(Ref.ID, "lapotronic_energy_orb", Tier.IV,100000000, true);
    public static ItemBasic<?> BatteryEnergyOrbCluster = new ItemBasic<>(Ref.ID, "battery_energy_orb_cluster");

    public static ItemBasic<?> EmptyShape = new ItemBasic<>(Ref.ID, "empty_shape_plate").tip("Raw plate to make Molds and Extruder Shapes");
    public static ItemBasic<?> MoldPlate = new ItemBasic<>(Ref.ID, "mold_plate").tip("Mold for making Plates");
    public static ItemBasic<?> MoldCasing = new ItemBasic<>(Ref.ID, "mold_casing").tip("Mold for making Item Casings - only usable with ic2");
    public static ItemBasic<?> MoldGear = new ItemBasic<>(Ref.ID, "mold_gear").tip("Mold for making Gears");
    public static ItemBasic<?> MoldCoinage = new ItemBasic<>(Ref.ID, "mold_coinage").tip("Secure Mold for making Coins (Don't lose it!)");
    public static ItemBasic<?> MoldBottle = new ItemBasic<>(Ref.ID, "mold_bottle").tip("Mold for making Bottles");
    public static ItemBasic<?> MoldIngot = new ItemBasic<>(Ref.ID, "mold_ingot").tip("Mold for making Ingots");
    public static ItemBasic<?> MoldBlock = new ItemBasic<>(Ref.ID, "mold_block").tip("Mold for making Blocks");
    public static ItemBasic<?> MoldNugget = new ItemBasic<>(Ref.ID, "mold_nugget").tip("Mold for making Nuggets");
    public static ItemBasic<?> ShapePlate = new ItemBasic<>(Ref.ID, "shape_plate").tip("Shape for making Plates");
    public static ItemBasic<?> ShapeRod = new ItemBasic<>(Ref.ID, "shape_rod").tip("Shape for making Rods");
    public static ItemBasic<?> ShapeCell = new ItemBasic<>(Ref.ID, "shape_cell").tip("Shape for making Cells");
    public static ItemBasic<?> ShapeIngot = new ItemBasic<>(Ref.ID, "shape_ingot").tip("Shape for making Ingots");
    public static ItemBasic<?> ShapeWire = new ItemBasic<>(Ref.ID, "shape_wire").tip("Shape for making Wires");
    public static ItemBasic<?> ShapeCasing = new ItemBasic<>(Ref.ID, "shape_casing").tip("Shape for making Item Casings - only usable with ic2");
    public static ItemBasic<?> ShapePipeTiny = new ItemBasic<>(Ref.ID, "shape_pipe_tiny").tip("Shape for making Tiny Pipes");
    public static ItemBasic<?> ShapePipeSmall = new ItemBasic<>(Ref.ID, "shape_pipe_small").tip("Shape for making Small Pipes");
    public static ItemBasic<?> ShapePipeNormal = new ItemBasic<>(Ref.ID, "shape_pipe_normal").tip("Shape for making Normal Pipes");
    public static ItemBasic<?> ShapePipeLarge = new ItemBasic<>(Ref.ID, "shape_pipe_large").tip("Shape for making Large Pipes");
    public static ItemBasic<?> ShapePipeHuge = new ItemBasic<>(Ref.ID, "shape_pipe_huge").tip("Shape for making Huge Pipes");
    public static ItemBasic<?> ShapeBlock = new ItemBasic<>(Ref.ID, "shape_block").tip("Shape for making Blocks");
    public static ItemBasic<?> ShapeHeadSword = new ItemBasic<>(Ref.ID, "shape_head_sword").tip("Shape for making Sword Blades");
    public static ItemBasic<?> ShapeHeadPickaxe = new ItemBasic<>(Ref.ID, "shape_head_pickaxe").tip("Shape for making Pickaxe Heads");
    public static ItemBasic<?> ShapeHeadShovel = new ItemBasic<>(Ref.ID, "shape_head_shovel").tip("Shape for making Shovel Heads");
    public static ItemBasic<?> ShapeHeadAxe = new ItemBasic<>(Ref.ID, "shape_head_axe").tip("Shape for making Axe Heads");
    public static ItemBasic<?> ShapeHeadHoe = new ItemBasic<>(Ref.ID, "shape_head_hoe").tip("Shape for making Hoe Heads");
    public static ItemBasic<?> ShapeHeadHammer = new ItemBasic<>(Ref.ID, "shape_head_hammer").tip("Shape for making Hammer Heads");
    public static ItemBasic<?> ShapeHeadFile = new ItemBasic<>(Ref.ID, "shape_head_file").tip("Shape for making File Heads");
    public static ItemBasic<?> ShapeHeadSaw = new ItemBasic<>(Ref.ID, "shape_head_saw").tip("Shape for making Saw Heads");
    public static ItemBasic<?> ShapeGear = new ItemBasic<>(Ref.ID, "shape_gear").tip("Shape for making Gears");
    public static ItemBasic<?> ShapeBottle = new ItemBasic<>(Ref.ID, "shape_bottle").tip("Shape for making Bottles"); //TODO needed?

    public static AntimatterToolType SPEAR = new AntimatterToolType(Ref.ID, "spear", 2, 1, 10, 3.0F, -2.9F){
        @Override
        public IAntimatterTool instantiateTools(String domain) {
            return new MaterialSpear(domain, this, prepareInstantiation(domain));
        }

        @Override
        public IAntimatterTool instantiateTools(String domain, Supplier<Item.Properties> properties) {
            return new MaterialSpear(domain, this, properties.get());
        }

        private Item.Properties prepareInstantiation(String domain) {
            if (domain.isEmpty()) Utils.onInvalidData("An AntimatterToolType was instantiated with an empty domain name!");
            Item.Properties properties = new Item.Properties().group(getItemGroup());
            if (!getRepairability()) properties.setNoRepair();
            return properties;
        }
    };

    //STONE should be the only non-removable StoneType. It serves as the foundation. It is also used natively by BlockRock
    //TODO move vanilla stone types (and (vanilla) materials) to Antimatter
    //public static StoneType STONE = new StoneType(Ref.ID, "stone", Materials.Stone, new Texture("minecraft", "block/stone"), SoundType.STONE, false).setState(Blocks.STONE);

    /*public static StoneType GRANITE = new StoneType(Ref.ID, "granite", Data.Granite, new Texture("minecraft", "block/granite"), SoundType.STONE, AntimatterConfig.WORLD.VANILLA_STONE_GEN || muramasa.antimatter.Ref.debugStones).setState(Blocks.GRANITE);
    public static StoneType DIORITE = new StoneType(Ref.ID, "diorite", Data.Diorite, new Texture("minecraft", "block/diorite"), SoundType.STONE, AntimatterConfig.WORLD.VANILLA_STONE_GEN || muramasa.antimatter.Ref.debugStones).setState(Blocks.DIORITE);
    public static StoneType ANDESITE = new StoneType(Ref.ID, "andesite", Data.Andesite, new Texture("minecraft", "block/andesite"), SoundType.STONE, AntimatterConfig.WORLD.VANILLA_STONE_GEN || muramasa.antimatter.Ref.debugStones).setState(Blocks.ANDESITE);

    public static StoneType GRAVEL = new StoneType(Ref.ID, "gravel", Data.Gravel, new Texture("minecraft", "block/gravel"), SoundType.GROUND, false).setState(Blocks.GRAVEL).setGravity(true).setBlockMaterial(net.minecraft.block.material.Material.SAND).setHardnessAndResistance(0.6F).setRequiresTool(false).setToolType(ToolType.SHOVEL);
    public static StoneType SAND = new StoneType(Ref.ID, "sand", Data.Sand, new Texture("minecraft", "block/sand"), SoundType.SAND, false).setState(Blocks.SAND).setGravity(true).setBlockMaterial(net.minecraft.block.material.Material.SAND).setHardnessAndResistance(0.5F).setRequiresTool(false).setToolType(ToolType.SHOVEL);
    public static StoneType SAND_RED = new StoneType(Ref.ID, "sand_red", Data.RedSand, new Texture("minecraft", "block/red_sand"), SoundType.SAND, false).setState(Blocks.RED_SAND).setGravity(true).setBlockMaterial(net.minecraft.block.material.Material.SAND).setHardnessAndResistance(0.5F).setRequiresTool(false).setToolType(ToolType.SHOVEL);
    public static StoneType SANDSTONE = new StoneType(Ref.ID, "sandstone", Data.Sandstone, new Texture("minecraft", "block/sandstone"), SoundType.STONE, false).setState(Blocks.SANDSTONE);
    public static StoneType BASALT_VANILLA = new StoneType(Ref.ID, "vanilla_basalt", Data.BasaltVanilla, new Texture("minecraft", "block/basalt_side"), SoundType.BASALT, false).setState(Blocks.BASALT).setHardnessAndResistance(1.25F, 4.2F);
    public static StoneType BLACKSTONE = new StoneType(Ref.ID, "blackstone", Data.Blackstone, new Texture("minecraft", "block/blackstone"), SoundType.STONE, false).setState(Blocks.BLACKSTONE);

    public static StoneType NETHERRACK = new StoneType(Ref.ID, "netherrack", Data.Netherrack, new Texture("minecraft", "block/netherrack"), SoundType.NETHERRACK, false).setState(Blocks.NETHERRACK).setHardnessAndResistance(0.4F);
    public static StoneType SOUL_SAND = new StoneType(Ref.ID, "soul_sand", Data.NULL, new Texture("minecraft", "block/soul_sand"), SoundType.SOUL_SAND, false).setState(Blocks.SOUL_SAND).setHardnessAndResistance(0.5F).setRequiresTool(false).setToolType(ToolType.SHOVEL);
    public static StoneType SOUL_SOIL = new StoneType(Ref.ID, "soul_soil", Data.NULL, new Texture("minecraft", "block/soul_soil"), SoundType.SOUL_SOIL, false).setState(Blocks.SOUL_SOIL).setHardnessAndResistance(0.5F).setRequiresTool(false).setToolType(ToolType.SHOVEL);
    public static StoneType ENDSTONE = new StoneType(Ref.ID, "endstone", Data.Endstone, new Texture("minecraft", "block/end_stone"), SoundType.STONE, false).setState(Blocks.END_STONE).setHardnessAndResistance(3.0F, 9.0F);*/

    public static StoneType GRANITE_RED = new StoneType(Ref.ID, "granite_red", Materials.RedGranite, new Texture(Ref.ID, "block/stone/granite_red"), SoundType.STONE, true).setHardnessAndResistance(4.5F, 60.0F).setHarvestLevel(3);
    public static StoneType GRANITE_BLACK = new StoneType(Ref.ID, "granite_black", Materials.BlackGranite, new Texture(Ref.ID, "block/stone/granite_black"), SoundType.STONE, true).setHardnessAndResistance(4.5F, 60.0F).setHarvestLevel(3);
    public static StoneType MARBLE = new StoneType(Ref.ID, "marble", Materials.Marble, new Texture(Ref.ID, "block/stone/marble"), SoundType.STONE, true).setHardnessAndResistance(0.75F,7.5F);
    public static StoneType BASALT = new StoneType(Ref.ID, "basalt", Materials.Basalt, new Texture(Ref.ID, "block/stone/basalt"), SoundType.STONE, true).setHardnessAndResistance(3.0F, 30.0F).setHarvestLevel(2);

    public static StoneType KOMATIITE = new StoneType(Ref.ID, "komatiite", Materials.Komatiite, new Texture(Ref.ID, "block/stone/komatiite"), SoundType.STONE, true).setHardnessAndResistance(3.0F, 30.0F).setHarvestLevel(2);
    public static StoneType LIMESTONE = new StoneType(Ref.ID, "limestone", Limestone, new Texture(Ref.ID, "block/stone/limestone"), SoundType.STONE, true).setHardnessAndResistance(0.75F,7.5F);
    public static StoneType GREEN_SCHIST = new StoneType(Ref.ID, "green_schist", GreenSchist, new Texture(Ref.ID, "block/stone/green_schist"), SoundType.STONE, true).setHardnessAndResistance(0.75F,7.5F);
    public static StoneType BLUE_SCHIST = new StoneType(Ref.ID, "blue_schist", BlueSchist, new Texture(Ref.ID, "block/stone/blue_schist"), SoundType.STONE, true).setHardnessAndResistance(0.75F,7.5F);
    public static StoneType KIMBERLITE = new StoneType(Ref.ID, "kimberlite", Kimberlite, new Texture(Ref.ID, "block/stone/kimberlite"), SoundType.STONE, true).setHardnessAndResistance(3.0F, 30.0F).setHarvestLevel(2);
    public static StoneType QUARTZITE = new StoneType(Ref.ID, "quartzite", Quartzite, new Texture(Ref.ID, "block/stone/quartzite"), SoundType.STONE, true).setHardnessAndResistance(0.75F,7.5F);


    public static final BlockConnectedCasing STANDARD_MACHINE_CASING = new BlockConnectedCasing(Ref.ID, "standard_machine_casing");
    public static final BlockConnectedCasing REINFORCED_MACHINE_CASING = new BlockConnectedCasing(Ref.ID, "reinforced_machine_casing");
    public static final BlockConnectedCasing ADVANCED_MACHINE_CASING = new BlockConnectedCasing(Ref.ID, "advanced_machine_casing");
    public static final BlockConnectedCasing TUNGSTENSTEEL_REINFORCED_STONE = new BlockConnectedCasing(Ref.ID, "tungstensteel_reinforced_stone");
    public static final BlockConnectedCasing IRIDIUM_TUNGSTENSTEEL_REINFORCED_STONE = new BlockConnectedCasing(Ref.ID, "iridium_tungstensteel_reinforced_stone");
    public static final BlockCasing HIGHLY_ADVANCED_MACHINE_BLOCK = new BlockCasing(Ref.ID, "highly_advanced_machine_block");
    public static final BlockCasing ADVANCED_MACHINE_BLOCK = new BlockCasing(Ref.ID, "advanced_machine_block");

    public static final BlockCasing FIRE_BRICKS = new BlockCasing(Ref.ID, "fire_bricks");
    public static final BlockCasing REINFORCED_GLASS = new BlockCasing(Ref.ID, "reinforced_glass");
    public static final BlockCasing REINFORCED_STONE = new BlockCasing(Ref.ID, "reinforced_stone");
    public static final BlockCasing IRIDIUM_REINFORCED_STONE = new BlockCasing(Ref.ID, "iridium_reinforced_stone");

    public static final BlockCasing FUSION_COIL = new BlockCasing(Ref.ID, "fusion_coil");

    public static final BlockSapBag SAP_BAG = new BlockSapBag();

    public static final Cable<?> CABLE_LEAD = new Cable<>(Ref.ID, Lead, 2, Tier.LV).amps(2);
    public static final Cable<?> CABLE_TIN = new Cable<>(Ref.ID, Tin, 1, Tier.LV).amps(1);
    public static final Cable<?> CABLE_COPPER = new Cable<>(Ref.ID, Copper, 2, Tier.MV).amps(1);
    public static final Cable<?> CABLE_NICKEL = new Cable<>(Ref.ID, Nickel, 3, Tier.MV).amps(3);
    public static final Cable<?> CABLE_GOLD = new Cable<>(Ref.ID, Gold, 2, Tier.HV).amps(3);
    public static final Cable<?> CABLE_ELECTRUM = new Cable<>(Ref.ID, Electrum, 2, Tier.HV).amps(2);
    public static final Cable<?> CABLE_STEEL = new Cable<>(Ref.ID, Steel, 2, Tier.EV).amps(2);
    public static final Cable<?> CABLE_ALUMINIUM = new Cable<>(Ref.ID, Aluminium, 1, Tier.EV).amps(1);
    public static final Cable<?> CABLE_OSMIUM = new Cable<>(Ref.ID, Osmium, 2, Tier.IV).amps(4);
    public static final Cable<?> CABLE_TUNGSTEN = new Cable<>(Ref.ID, Tungsten, 2, Tier.IV).amps(2);

    public static final Wire<?> WIRE_LEAD = new Wire<>(Ref.ID, Lead, 4, Tier.LV).amps(2);
    public static final Wire<?> WIRE_TIN = new Wire<>(Ref.ID, Tin, 2, Tier.LV).amps(1);
    public static final Wire<?> WIRE_COPPER = new Wire<>(Ref.ID, Copper, 4, Tier.MV).amps(1);
    public static final Wire<?> WIRE_NICKEL = new Wire<>(Ref.ID, Nickel, 6, Tier.MV).amps(3);
    public static final Wire<?> WIRE_GOLD = new Wire<>(Ref.ID, Gold, 6, Tier.HV).amps(3);
    public static final Wire<?> WIRE_ELECTRUM = new Wire<>(Ref.ID, Electrum, 4, Tier.HV).amps(2);
    public static final Wire<?> WIRE_STEEL = new Wire<>(Ref.ID, Steel, 4, Tier.EV).amps(2);
    public static final Wire<?> WIRE_ALUMINIUM = new Wire<>(Ref.ID, Aluminium, 1, Tier.EV).amps(1);
    public static final Wire<?> WIRE_OSMIUM = new Wire<>(Ref.ID, Osmium, 4, Tier.IV).amps(4);
    public static final Wire<?> WIRE_TUNGSTEN = new Wire<>(Ref.ID, Tungsten, 4, Tier.IV).amps(2);
    public static final Wire<?> WIRE_SUPERCONDUCTOR = new Wire<>(Ref.ID, Superconductor, 0, Tier.MAX).amps(4); //MAX

    public static final FluidPipe<?> FLUID_PIPE_BRONZE = new FluidPipe<>(Ref.ID, Bronze, 1000, false).sizes().caps(10, 10, 30, 60, 60, 60).pressures(400, 400, 400, 400, 400, 400);
    public static final FluidPipe<?> FLUID_PIPE_INVAR = new FluidPipe<>(Ref.ID, Invar, 1300, true).caps(60).pressures(1000);
    public static final FluidPipe<?> FLUID_PIPE_STEEL = new FluidPipe<>(Ref.ID, Steel, 1300, true).caps(60).pressures(1000);
    public static final FluidPipe<?> FLUID_PIPE_STAINLESS_STEEL = new FluidPipe<>(Ref.ID, StainlessSteel, 1300, true).caps(60).pressures(1000);
    public static final FluidPipe<?> FLUID_PIPE_TUNGSTEN_STEEL = new FluidPipe<>(Ref.ID, TungstenSteel, 3422, true).caps(100).pressures(5000);
    public static final FluidPipe<?> FLUID_PIPE_HP = new FluidPipe<>(Ref.ID, HighPressure, 3422, true).sizes(PipeSize.SMALL, PipeSize.NORMAL, PipeSize.LARGE).caps(4800, 4800, 4800, 7200, 9600, 9600).pressures(10000);

    /*public static final ItemPipe<?> ITEM_PIPE_WOOD = new ItemPipe<>(Ref.ID, Wood).sizes(PipeSize.SMALL).caps(0, 0, 1, 0, 0, 0);
    public static final ItemPipe<?> ITEM_PIPE_WROUGHT_IRON = new ItemPipe<>(Ref.ID, WroughtIron).sizes(PipeSize.SMALL, PipeSize.NORMAL, PipeSize.LARGE).caps(0, 0, 2, 3, 4, 0);
    public static final ItemPipe<?> ITEM_PIPE_PLATINUM = new ItemPipe<>(Ref.ID, Platinum).caps(5).sizes(PipeSize.SMALL, PipeSize.NORMAL, PipeSize.LARGE);
    public static final ItemPipe<?> ITEM_PIPE_HC = new ItemPipe<>(Ref.ID, HighCapacity).caps(10);
    public static final ItemPipe<?> ITEM_PIPE_OSMIRIDIUM = new ItemPipe<>(Ref.ID, Osmiridium).caps(20);*/

    // Rubber Tree
    public static final BlockRubberLeaves RUBBER_LEAVES = new BlockRubberLeaves(Ref.ID, "rubber_leaves");
    public static final BlockRubberLog RUBBER_LOG = new BlockRubberLog(Ref.ID, "rubber_log");
    public static final BlockRubberSapling RUBBER_SAPLING = new BlockRubberSapling(Ref.ID, "rubber_sapling");

    public static final ImmutableMap<Integer, RecipeIngredient> INT_CIRCUITS;
    public static final ImmutableMap<Integer, Item> INT_CIRCUITS_ITEMS;
    public static final ImmutableMap<Tier, Material> TIER_MATERIALS;
    public static ImmutableMap<Tier, Wire<?>> TIER_WIRES;
    public static ImmutableMap<Tier, Cable<?>> TIER_CABLES;

    public static ImmutableMap<Tier, Item> TIER_ROTORS;
    public static ImmutableMap<Tier, Item> TIER_BATTERIES;
    public static ImmutableMap<Tier, FluidPipe> TIER_PIPES;
}
