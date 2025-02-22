package trinsdar.gt4r.loader.crafting;

import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Tags;
import trinsdar.gt4r.Ref;

import java.util.function.Consumer;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.Data.PLATE;
import static trinsdar.gt4r.data.CustomTags.*;
import static trinsdar.gt4r.data.CustomTags.CIRCUITS_ADVANCED;
import static trinsdar.gt4r.data.GT4RData.*;
import static trinsdar.gt4r.data.Materials.Carbon;
import static trinsdar.gt4r.data.Materials.Chrome;
import static trinsdar.gt4r.data.Materials.Titanium;

public class BlockCrafting {
    public static void loadRecipes(Consumer<IFinishedRecipe> output, AntimatterRecipeProvider provider) {
        provider.addStackRecipe(output, Ref.ID, "firebricks", "blocks", "has_fire_brick", provider.hasSafeItem(FireBrick),
                new ItemStack(FIRE_BRICKS), of('F', FireBrick), "FF", "FF");
        provider.addStackRecipe(output, Ref.ID, "reinforce_glass_v", "blocks", "has_advanced_alloy", provider.hasSafeItem(AdvancedAlloy),
                new ItemStack(REINFORCED_GLASS, 7), of('G', Tags.Items.GLASS, 'A', AdvancedAlloy), "GAG", "GGG", "GAG");
        provider.addStackRecipe(output, Ref.ID, "reinforce_glass_h", "blocks", "has_advanced_alloy", provider.hasSafeItem(AdvancedAlloy),
                new ItemStack(REINFORCED_GLASS, 7), of('G', Tags.Items.GLASS, 'A', AdvancedAlloy), "GGG", "AGA", "GGG");
        provider.addStackRecipe(output, Ref.ID, "standard_machine", "blocks", "has_circuit_basic", provider.hasSafeItem(CIRCUITS_BASIC),
                new ItemStack(STANDARD_MACHINE_CASING, 4), of('I', PLATES_WROUGHT_ALUMINIUM, 'C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_SEMI_CHEAP), "III", "CMC", "III");
        provider.addStackRecipe(output, Ref.ID, "reinforced_machine", "blocks", "has_circuit_advanced", provider.hasSafeItem(CIRCUITS_ADVANCED),
                new ItemStack(REINFORCED_MACHINE_CASING, 4), of('I', PLATES_STEELS, 'C', CIRCUITS_ADVANCED, 'M', MACHINE_HULLS_BASIC), "III", "CMC", "III");
        provider.addStackRecipe(output, Ref.ID, "advanced_machine", "blocks", "has_circuit_elite", provider.hasSafeItem(CIRCUITS_ELITE),
                new ItemStack(ADVANCED_MACHINE_CASING, 4), of('I', PLATE.getMaterialTag(Chrome), 'C', CIRCUITS_ELITE, 'M', HIGHLY_ADVANCED_MACHINE_BLOCK), "III", "CMC", "III");
        provider.addStackRecipe(output, Ref.ID, "highly_advanced_machine", "blocks", "has_machine_hull_advanced", provider.hasSafeItem(MACHINE_HULLS_ADVANCED),
                new ItemStack(HIGHLY_ADVANCED_MACHINE_BLOCK, 1), of('T', PLATE.getMaterialTag(Titanium), 'C', PLATE.getMaterialTag(Chrome), 'M', MACHINE_HULLS_ADVANCED), "CTC", "TMT", "CTC");
        provider.addStackRecipe(output, Ref.ID, "machine_block_advanced_1", "blocks", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                new ItemStack(ADVANCED_MACHINE_BLOCK, 1), of('A', AdvancedAlloy, 'C', PLATE.getMaterialTag(Carbon), 'M', MACHINE_HULLS_BASIC), " C ", "AMA", " C ");
        provider.addStackRecipe(output, Ref.ID, "machine_block_advanced_2", "blocks", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                new ItemStack(ADVANCED_MACHINE_BLOCK, 1), of('A', AdvancedAlloy, 'C', PLATE.getMaterialTag(Carbon), 'M', MACHINE_HULLS_BASIC), " A ", "CMC", " A ");

    }
}
