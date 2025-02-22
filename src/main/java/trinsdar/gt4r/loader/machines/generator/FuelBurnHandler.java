package trinsdar.gt4r.loader.machines.generator;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.material.Material;
import trinsdar.gt4r.data.Materials;

import static muramasa.antimatter.Data.GAS;
import static muramasa.antimatter.Data.LIQUID;
import static trinsdar.gt4r.data.Materials.*;
import static trinsdar.gt4r.data.RecipeMaps.DIESEL_FUELS;
import static trinsdar.gt4r.data.RecipeMaps.GAS_FUELS;
import static trinsdar.gt4r.data.RecipeMaps.SEMIFLUID_FUELS;
import static trinsdar.gt4r.data.RecipeMaps.STEAM_FUELS;

public class FuelBurnHandler {
    public static void init() {
        AntimatterAPI.all(Material.class, mat -> {
            if (mat != Materials.Steam && mat.getFuelPower() > 0) {
                if (mat.has(LIQUID)) {
                    int power = 16, ticks = mat.getFuelPower() / 16;
                    if (mat.getFuelPower() < 16) {
                        ticks = 1;
                        power = mat.getFuelPower();
                    }
                    if (mat == NitroDiesel){
                        ticks = mat.getFuelPower() / 32;
                        power = 32;
                    }
                    if (mat == Biomass || mat == SeedOil || mat == Oil){
                        SEMIFLUID_FUELS.RB().fi(mat.getLiquid(1)).add(ticks, power);
                    } else {
                        DIESEL_FUELS.RB().fi(mat.getLiquid(1)).add(ticks, power);
                    }

                }
                if (mat.has(GAS)) {
                    int power = 16, ticks = mat.getFuelPower() / 16;
                    if (mat.getFuelPower() < 16 || (mat.getFuelPower() < 32 && mat.getFuelPower() > 16)) {
                        ticks = 1;
                        power = mat.getFuelPower();
                    }
                    GAS_FUELS.RB().fi(mat.getGas(1)).add(ticks, power);
                }
            }
        });
        STEAM_FUELS.RB().fi(Steam.getGas(32)).add(1,16);

    }
}
