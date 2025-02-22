package trinsdar.gt4r.loader.crafting;

import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.pipe.PipeSize;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;
import net.minecraftforge.common.Tags;
import trinsdar.gt4r.Ref;

import java.util.function.Consumer;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.machine.Tier.*;
import static muramasa.antimatter.util.TagUtils.getForgeItemTag;
import static trinsdar.gt4r.data.CustomTags.*;
import static trinsdar.gt4r.data.GT4RData.*;
import static trinsdar.gt4r.data.Machines.*;
import static trinsdar.gt4r.data.Materials.*;
import static trinsdar.gt4r.loader.crafting.CraftingHelper.criterion;

public class MachineCrafting {
    public static void loadRecipes(Consumer<IFinishedRecipe> output, AntimatterRecipeProvider provider) {
        provider.addItemRecipe(output, Ref.ID, "electrolyzer", "machines", "has_extractor", provider.hasSafeItem(EXTRACTOR.getItem(LV)),
                ELECTROLYZER.getItem(MV), of('C', CIRCUITS_ADVANCED, 'P', PLATES_STEELS, 'E', EXTRACTOR.getItem(LV), 'L', CopperCoil), "PEP", "CLC", "PEP");
        provider.addItemRecipe(output, Ref.ID, "industrial_grinder", "machines", "has_electrolyzer", provider.hasSafeItem(ELECTROLYZER.getItem(MV)),
                INDUSTRIAL_GRINDER.getItem(MV), of('E', ELECTROLYZER.getItem(MV),'C', CIRCUITS_ADVANCED, 'M', MACHINE_HULLS_BASIC, 'P', PUMP.getItem(LV), 'G', GRINDING_HEAD), "ECP", "GGG", "CMC");
        provider.addItemRecipe(output, Ref.ID, "industrial_blast_furnace", "machines", "has_cupronickel_coils", provider.hasSafeItem(CupronickelHeatingCoil),
                BLAST_FURNACE.getItem(MV), of('C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'H', CupronickelHeatingCoil, 'F', FURNACE.getItem(LV)), "CHC", "HMH", "FHF");
        provider.addItemRecipe(output, Ref.ID, "implosion_compressor", "machines", "has_compressor", provider.hasSafeItem(COMPRESSOR.getItem(LV)),
                IMPLOSION_COMPRESSOR.getItem(LV), of('C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'c', COMPRESSOR.getItem(LV), 'A', AdvancedAlloy), "AMA", "CcC", "AMA");
        provider.addItemRecipe(output, Ref.ID, "industrial_sawmill", "machines", "has_pump", provider.hasSafeItem(PUMP.getItem(LV)),
                INDUSTRIAL_SAWMILL.getItem(MV), of('C', CIRCUITS_ADVANCED, 'M', MACHINE_HULLS_BASIC, 'P', PUMP.getItem(LV), 'S', DiamondSawBlade), "PCP", "SSS", "CMC");
        provider.addItemRecipe(output, Ref.ID, "vacuum_freezer", "machines", "has_pump", provider.hasSafeItem(PUMP.getItem(LV)),
                VACUUM_FREEZER.getItem(LV), of('C', CIRCUITS_BASIC, 'G', REINFORCED_GLASS, 'P', PUMP.getItem(LV), 'A', PLATE.getMaterialTag(Aluminium)), "APA", "CGC", "APA");
        provider.addItemRecipe(output, Ref.ID, "chemical_reactor", "machines", "has_extractor", provider.hasSafeItem(EXTRACTOR.getItem(LV)),
                CHEMICAL_REACTOR.getItem(MV), of('C', CIRCUITS_ADVANCED, 'P', PLATES_INVAR_ALUMINIUM, 'E', EXTRACTOR.getItem(LV), 'L', CopperCoil, 'c', COMPRESSOR.getItem(LV)), "PLP", "CcC", "PEP");
        provider.addItemRecipe(output, Ref.ID, "distillation_tower", "machines", "has_centrifuge", provider.hasSafeItem(CENTRIFUGE.getItem(LV)),
                DISTILLATION_TOWER.getItem(MV), of('C', CIRCUITS_MASTER, 'P', PUMP.getItem(LV), 'E', ELECTROLYZER.getItem(MV), 'c', CENTRIFUGE.getItem(LV), 'A', HIGHLY_ADVANCED_MACHINE_BLOCK), "cCc", "PAP", "ECE");
        provider.addItemRecipe(output, Ref.ID, "macerator_1", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                MACERATOR.getItem(LV), of('C', CIRCUITS_ADVANCED, 'P', PLATES_STEELS, 'M', MACHINE_HULLS_BASIC, 'D', DUST.getMaterialTag(Diamond)), "PDP", "DMD", "PCP");
        provider.addItemRecipe(output, Ref.ID, "macerator_2", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                MACERATOR.getItem(LV), of('C', CIRCUITS_BASIC, 'P', PLATES_STEELS, 'M', MACHINE_HULLS_BASIC, 'D', GRINDING_HEAD), "PDP", "CMC", "PCP");
        provider.addItemRecipe(output, Ref.ID,"extractor","machines", "has_piston", provider.hasSafeItem(PISTONS),
                EXTRACTOR.getItem(LV), of('C', CIRCUITS_BASIC, 'P', PISTONS, 'M', MACHINE_HULLS_BASIC, 'G', getForgeItemTag("glass")), "GMG", "PCP");
        provider.addItemRecipe(output, Ref.ID,"compressor","machines", "has_piston", provider.hasSafeItem(PISTONS),
                COMPRESSOR.getItem(LV), of('C', CIRCUITS_BASIC, 'P', PISTONS, 'M', MACHINE_HULLS_BASIC, 'S', getForgeItemTag("stone")), "S S", "PMP", "SCS");
        provider.addItemRecipe(output, Ref.ID,"forge_hammer","machines", "has_piston", provider.hasSafeItem(PISTONS),
                FORGE_HAMMER.getItem(LV), of('C', CIRCUITS_BASIC, 'P', PISTONS, 'M', MACHINE_HULLS_BASIC, 'A', Items.ANVIL), " P ", "CMC", " A ");
        provider.addItemRecipe(output, Ref.ID,"e_furnace","machines", "has_steam_furnace", provider.hasSafeItem(STEAM_FURNACE.getItem(STEEL)),
                FURNACE.getItem(LV), of('C', CIRCUITS_BASIC, 'S', STEAM_FURNACE.getItem(STEEL), 'R', DUST.getMaterialTag(Redstone)), " C ", "RSR");
        provider.addItemRecipe(output, Ref.ID,"wiremill","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                WIRE_MILL.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', MACHINE_HULLS_BASIC, 'D', GEM.getMaterialTag(Diamond), 'B', PLATE.getMaterialTag(Brass)), "BDB", "CMC", "BcB");
        provider.addItemRecipe(output, Ref.ID,"alloy_smelter","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                ALLOY_SMELTER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', FURNACE.getItem(LV), 'D', CupronickelHeatingCoil, 'B', PLATE.getMaterialTag(Invar)), "BDB", "CMC", "BcB");
        provider.addItemRecipe(output, Ref.ID,"canner","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                CANNER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', MACHINE_HULLS_BASIC, 'T', PLATE.getMaterialTag(Tin)), "TCT", "TMT", "TcT");
        provider.addItemRecipe(output, Ref.ID,"plate_bender","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                BENDER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', COMPRESSOR.getItem(LV), 'P', PISTONS), "PCP", "McM", "PCP");
        provider.addItemRecipe(output, Ref.ID,"assembler","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                ASSEMBLER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'S', PLATES_STEELS, 'P', PISTONS), "CPC", "ScS", "CSC");
        //provider.addItemRecipe(output, Ref.ID,"printing_factory","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
        //        PRINTING_FACTORY.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'S', PLATES_STEELS, 'P', PISTONS), "SPS", "CcC", "SSS");
        provider.addItemRecipe(output, Ref.ID,"centrifuge","machines", "has_extractor", provider.hasSafeItem(EXTRACTOR.getItem(LV)),
                CENTRIFUGE.getItem(LV), of('C', CIRCUITS_ADVANCED, 'E', EXTRACTOR.getItem(LV), 'S', PLATES_STEELS, 'M', MACHINE_HULLS_BASIC), "SCS", "MEM", "SCS");
        provider.addItemRecipe(output, Ref.ID,"universal_macerator","machines", "has_macerator", provider.hasSafeItem(MACERATOR.getItem(LV)),
                UNIVERSAL_MACERATOR.getItem(MV), of('D', GRINDING_HEAD, 'M', MACERATOR.getItem(LV), 'S', PLATE.getMaterialTag(Titanium), 'H', MACHINE_HULLS_VERY_ADVANCED), "SDS", "SMS", "SHS");
        provider.addItemRecipe(output, Ref.ID,"fluid_canner","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                FLUID_CANNER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', CANNER.getItem(LV), 'T', getForgeItemTag("plates/tin"), 'P', FLUID_PIPE_BRONZE.getBlockItem(PipeSize.SMALL), 'E', CellTin), " C ", "EcE", "TPT");
        provider.addItemRecipe(output, Ref.ID,"large_gas_turbine","machines", "has_gas_turbine", provider.hasSafeItem(GAS_TURBINE.getItem(LV)),
                LARGE_GAS_TURBINE.getItem(IV), of('G', GAS_TURBINE.getItem(LV), 'T', GEARS_TITAN_TUNGSTEEL, 'H', MACHINE_HULLS_VERY_ADVANCED, 'C', CIRCUITS_MASTER), "GGG", "THT", "GCG");
        provider.addItemRecipe(output, Ref.ID,"large_steam_turbine","machines", "has_steam_turbine", provider.hasSafeItem(STEAM_TURBINE.getItem(LV)),
                LARGE_STEAM_TURBINE.getItem(EV), of('G', STEAM_TURBINE.getItem(LV), 'T', GEARS_STEELS, 'H', MACHINE_HULLS_BASIC, 'C', CIRCUITS_ADVANCED), "GGG", "THT", "GCG");
        provider.addItemRecipe(output, Ref.ID,"thermal_boiler","machines", "has_thermal_generator", provider.hasSafeItem(HEAT_EXCHANGER.getItem(LV)),
                THERMAL_BOILER.getItem(LV), of('G', HEAT_EXCHANGER.getItem(LV), 'T', GEARS_TITAN_TUNGSTEEL, 'M', CENTRIFUGE.getItem(LV), 'C', CIRCUITS_ELITE), "GMG", "TCT", "GMG");
        provider.addItemRecipe(output, Ref.ID,"lathe","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                LATHE.getItem(LV), of('c', ConveyorModule, 'G', GEARS_STEELS, 'H', MACHINE_HULLS_BASIC, 'C', CIRCUITS_ADVANCED, 'P',  PLATES_STEELS), "PCP", "GcG", "PHP");
        provider.addItemRecipe(output, Ref.ID,"cutter","machines", "has_sawblade", provider.hasSafeItem(DiamondSawBlade),
                CUTTER.getItem(LV), of('D', DiamondSawBlade, 'G', GEARS_STEELS, 'H', MACHINE_HULLS_BASIC, 'C', CIRCUITS_ADVANCED, 'P',  PLATES_STEELS), "PCP", "GDG", "PHP");
        provider.addItemRecipe(output, Ref.ID, "extruder", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_VERY_ADVANCED),
                EXTRUDER.getItem(MV), CraftingHelper.of2('P', PLATES_TITAN_TUNGSTEEL, 'G', GEARS_TITAN_TUNGSTEEL, 'H', NichromeHeatingCoil, 'M', MACHINE_HULLS_VERY_ADVANCED, 'D', DiamondSawBlade, 'C', CIRCUITS_ELITE), "PGP", "HMD", "PCP");
        provider.addItemRecipe(output, Ref.ID,"small_coil_boiler","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                COAL_BOILER.getItem(BRONZE), of( 'P',  getForgeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', Items.FURNACE), "PPP", "PWP", "BFB");
        provider.addItemRecipe(output, Ref.ID,"steam_macerator","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_MACERATOR.getItem(BRONZE), CraftingHelper.of2( 'P',  getForgeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'H', HAMMER.getTag(), 'D', GEM.getMaterialTag(Diamond), 'M', MACHINE_HULLS_CHEAP, 'p', PISTONS, 'G', GEAR.getMaterialTag(Bronze)), "WDH", "GMG", "PpP");
        provider.addItemRecipe(output, Ref.ID,"steam_furnace","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_FURNACE.getItem(BRONZE), of( 'P',  getForgeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', Items.FURNACE, 'M', MACHINE_HULLS_CHEAP), "PWP", "PFP", "BMB");
        provider.addItemRecipe(output, Ref.ID,"steam_alloy_smelter","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_ALLOY_SMELTER.getItem(BRONZE), of( 'P',  getForgeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', STEAM_FURNACE.getItem(BRONZE)), "PPP", "FWF", "BBB");
        provider.addItemRecipe(output, Ref.ID,"steam_forge_hammer","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_FORGE_HAMMER.getItem(BRONZE), of( 'B',  getForgeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'G', GEAR.getMaterialTag(Bronze), 'P', PISTONS, 'M', MACHINE_HULLS_CHEAP), "GPG", "BWB", "BMB");
        provider.addItemRecipe(output, Ref.ID,"steam_compressor","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_COMPRESSOR.getItem(BRONZE), of( 'B',  getForgeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'G', GEAR.getMaterialTag(Bronze), 'P', PISTONS, 'M', MACHINE_HULLS_CHEAP), "BGB", "PWP", "BMB");
        provider.addItemRecipe(output, Ref.ID,"steam_extractor","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_EXTRACTOR.getItem(BRONZE), of( 'B',  getForgeItemTag("plates/bronze"), 'W', WRENCH.getTag(),'P', PISTONS, 'M', MACHINE_HULLS_CHEAP), "BBB", "PWP", "BMB");
        provider.addItemRecipe(output, Ref.ID,"high_pressure_coil_boiler","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                COAL_BOILER.getItem(STEEL), of( 'P',  PLATES_STEELS, 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', Items.FURNACE), "PPP", "PWP", "BFB");
        provider.addItemRecipe(output, Ref.ID,"high_pressure_steam_furnace","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_FURNACE.getItem(STEEL), of( 'P',  PLATES_STEELS, 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', Items.FURNACE, 'M', MACHINE_HULLS_SEMI_CHEAP), "PWP", "PFP", "BMB");
        provider.addItemRecipe(output, Ref.ID, "diesel_generator", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                DIESEL_GENERATOR.getItem(LV), of('P', PLATES_WROUGHT_ALUMINIUM, 'B', BatteryRE, 'C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC), "PBP", "P P", "CMC");
        provider.addItemRecipe(output, Ref.ID, "semifluid_generator", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                SEMIFLUID_GENERATOR.getItem(LV), of('P', PLATES_WROUGHT_ALUMINIUM, 'B', BatteryRE, 'C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'R', REINFORCED_GLASS), "PBP", "PRP", "CMC");
        provider.addItemRecipe(output, Ref.ID, "gas_turbine", "machines", "has_windmill", provider.hasSafeItem(WINDMILL.getItem(ULV)),
                GAS_TURBINE.getItem(LV), of('P', PLATES_INVAR_ALUMINIUM, 'W', WINDMILL.getItem(ULV), 'C', CIRCUITS_ADVANCED, 'G', REINFORCED_GLASS), "PCP", "WGW", "PCP");
        //TODO: replace turbine blade with turbine rotor
        provider.addItemRecipe(output, Ref.ID, "steam_turbine", "machines", "has_watermill", provider.hasSafeItem(WATERMILL.getItem(ULV)),
                STEAM_TURBINE.getItem(LV), of('P', PLATES_WROUGHT_ALUMINIUM, 'W', WATERMILL.getItem(ULV), 'C', CIRCUITS_BASIC, 'B', TURBINE_BLADE.getMaterialTag(Steel)), "PCP", "WBW", "PCP");
        provider.addItemRecipe(output, Ref.ID, "primitive_blast_furnace", "machines", "has_fire_bricks", provider.hasSafeItem(FIRE_BRICKS),
                PRIMITIVE_BLAST_FURNACE.getItem(BRONZE), of('B', FIRE_BRICKS, 'I', PLATE.getMaterialTag(Iron)), "BBB", "BIB", "BBB");
        provider.addItemRecipe(output, Ref.ID, "coke_oven", "machines", "has_fire_bricks", provider.hasSafeItem(FIRE_BRICKS),
                COKE_OVEN.getItem(LV), of('B', FIRE_BRICKS), "BBB", "B B", "BBB");
        BATTERY_BUFFER_ONE.getTiers().forEach(t -> {
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_batter_buffer_one", "machines", "has_machine_hull", provider.hasSafeItem(HULL.getMaterialTag(TIER_MATERIALS.get(t))),
                    BATTERY_BUFFER_ONE.getItem(t), of('H', HULL.get(TIER_MATERIALS.get(t)), 'C', Tags.Items.CHESTS, 'W', TIER_WIRES.get(t).getBlockItem(PipeSize.VTINY)), "WCW", "WHW");
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_batter_buffer_four", "machines", "has_machine_hull", provider.hasSafeItem(HULL.getMaterialTag(TIER_MATERIALS.get(t))),
                    BATTERY_BUFFER_FOUR.getItem(t), of('H', HULL.get(TIER_MATERIALS.get(t)), 'C', Tags.Items.CHESTS, 'W', TIER_WIRES.get(t).getBlockItem(PipeSize.SMALL)), "WCW", "WHW");
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_batter_buffer_nine", "machines", "has_machine_hull", provider.hasSafeItem(HULL.getMaterialTag(TIER_MATERIALS.get(t))),
                    BATTERY_BUFFER_NINE.getItem(t), of('H', HULL.get(TIER_MATERIALS.get(t)), 'C', Tags.Items.CHESTS, 'W', TIER_WIRES.get(t).getBlockItem(PipeSize.NORMAL)), "WCW", "WHW");
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_batter_buffer_one_bat", "machines", "has_plate", provider.hasSafeItem(PLATE.getMaterialTag(TIER_MATERIALS.get(t))),
                    BATTERY_BUFFER_ONE.getItem(t), of('P', PLATE.getMaterialTag(TIER_MATERIALS.get(t)), 'B', TIER_BATTERIES.get(t), 'W', TIER_WIRES.get(t).getBlockItem(PipeSize.VTINY)),"PPP", "WBW", "WPW");
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_batter_buffer_four_bat", "machines", "has_plate", provider.hasSafeItem(PLATE.getMaterialTag(TIER_MATERIALS.get(t))),
                    BATTERY_BUFFER_FOUR.getItem(t), of('P', PLATE.getMaterialTag(TIER_MATERIALS.get(t)), 'B', TIER_BATTERIES.get(t), 'W', TIER_WIRES.get(t).getBlockItem(PipeSize.SMALL)),"PPP", "WBW", "WPW");
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_batter_buffer_nine_bat", "machines", "has_plate", provider.hasSafeItem(PLATE.getMaterialTag(TIER_MATERIALS.get(t))),
                    BATTERY_BUFFER_NINE.getItem(t), of('P', PLATE.getMaterialTag(TIER_MATERIALS.get(t)), 'B', TIER_BATTERIES.get(t), 'W', TIER_WIRES.get(t).getBlockItem(PipeSize.NORMAL)),"PPP", "WBW", "WPW");
        });
        provider.addItemRecipe(output, Ref.ID, "drum_bronze", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                BRONZE_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Bronze), 'P', PLATE.getMaterialTag(Bronze)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_steel", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                STEEL_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Steel), 'P', PLATE.getMaterialTag(Steel)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_invar", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                INVAR_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Invar), 'P', PLATE.getMaterialTag(Invar)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_stainless_steel", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                STAINLESS_STEEL_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(StainlessSteel), 'P', PLATE.getMaterialTag(StainlessSteel)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_netherite", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                NETHERITE_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Netherite), 'P', PLATE.getMaterialTag(Netherite)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_tungsten", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                TUNGSTEN_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Tungsten), 'P', PLATE.getMaterialTag(Tungsten)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_tungstensteel", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                TUNGSTENSTEEL_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(TungstenSteel), 'P', PLATE.getMaterialTag(TungstenSteel)), " H ", "PRP", "PRP");
        TRANSFORMER.getTiers().forEach(t -> {
            if (t.getVoltage() <= EV.getVoltage()){
                provider.addItemRecipe(output, Ref.ID, t.getId() + "_transformer", "machines", "has_machine_hull", provider.hasSafeItem(HULL.getMaterialTag(TIER_MATERIALS.get(t))),
                        TRANSFORMER.getItem(t), of( 'C', TIER_CABLES.get(t).getBlockItem(PipeSize.VTINY), 'M', HULL.getMaterialTag(TIER_MATERIALS.get(t)), 'c', TIER_CABLES.get(Tier.getTier(t.getVoltage() * 4)).getBlockItem(PipeSize.VTINY))," CC", "cM ", " CC");
            }
        });
        provider.addItemRecipe(output, Ref.ID, "pump", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                PUMP.getItem(LV), of('c', CellTin, 'C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'P', FLUID_PIPE_BRONZE.getBlockItem(PipeSize.SMALL)),"cCc", "cMc", "PPP");
        provider.addItemRecipe(output, Ref.ID, "ore_washer", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                ORE_WASHER.getItem(LV), of('m', MotorLV, 'C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'P', PLATE.getMaterialTag(Iron), 'B', Items.BUCKET),"PPP", "BMB", "mCm");
        provider.addItemRecipe(output, Ref.ID, "thermal_centrifuge", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_ADVANCED),
                THERMAL_CENTRIFUGE.getItem(MV), of('m', MotorMV, 'C', CopperCoil, 'M', MACHINE_HULLS_ADVANCED, 'P', PLATE.getMaterialTag(WroughtIron)),"CmC", "PMP", "PmP");
    }

}
