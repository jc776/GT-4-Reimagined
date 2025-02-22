package trinsdar.gt4r.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import muramasa.antimatter.gui.container.ContainerBasicMachine;
import muramasa.antimatter.gui.screen.ScreenBasicMachine;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import trinsdar.gt4r.tile.multi.TileEntityIndustrialBlastFurnace;

public class ScreenIBF extends ScreenBasicMachine<ContainerBasicMachine> {
    public ScreenIBF(ContainerBasicMachine container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack stack, int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(stack, mouseX, mouseY);
        this.getContainer().getTile().drawInfo(stack, Minecraft.getInstance().fontRenderer, mouseX, mouseY);
    }
}
