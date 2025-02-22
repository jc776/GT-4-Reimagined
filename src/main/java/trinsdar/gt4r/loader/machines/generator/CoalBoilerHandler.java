package trinsdar.gt4r.loader.machines.generator;

import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import net.minecraft.item.Items;

import static muramasa.antimatter.Data.DUST;
import static muramasa.antimatter.Data.GEM;
import static trinsdar.gt4r.data.Materials.Ash;
import static trinsdar.gt4r.data.Materials.CoalCoke;
import static trinsdar.gt4r.data.Materials.DarkAsh;
import static trinsdar.gt4r.data.RecipeMaps.COAL_BOILERS;

public class CoalBoilerHandler {
    public static void init(){
        COAL_BOILERS.RB().ii(RecipeIngredient.of(Items.COAL, 1)).io(DUST.get(DarkAsh, 1)).add(160);
        COAL_BOILERS.RB().ii(RecipeIngredient.of(Items.CHARCOAL, 1)).io(DUST.get(Ash, 1)).add(160);
        COAL_BOILERS.RB().ii(RecipeIngredient.of(GEM.get(CoalCoke), 1)).io(DUST.get(DarkAsh, 1)).add(320);
    }
}
