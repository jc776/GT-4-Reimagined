package trinsdar.gt4r.datagen;

import muramasa.antimatter.Data;
import trinsdar.gt4r.Ref;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

import static muramasa.antimatter.datagen.providers.AntimatterAdvancementProvider.buildRootAdvancement;
import static muramasa.antimatter.datagen.providers.AntimatterAdvancementProvider.getLoc;
import static muramasa.antimatter.util.TagUtils.getForgeItemTag;
import static muramasa.antimatter.util.Utils.hasItem;
import static trinsdar.gt4r.data.Materials.Flint;

public class ProgressionAdvancements implements Consumer<Consumer<Advancement>> {

    //public static Advancement progressionRoot;

    @Override
    public void accept(Consumer<Advancement> consumer) {
        /*progressionRoot = buildRootAdvancement(Data.ROCK.get(Flint), new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        Ref.ID + ".advancements.greg", Ref.ID + ".advancements.greg.desc", FrameType.TASK, true, true, false)
                        .withCriterion("has_rocks", hasItem(getForgeItemTag("rocks"))).register(consumer, getLoc(Ref.ID, "progression/root"));*/
    }

}
