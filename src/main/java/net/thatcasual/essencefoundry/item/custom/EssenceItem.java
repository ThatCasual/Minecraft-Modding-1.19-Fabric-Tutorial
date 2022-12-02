package net.thatcasual.essencefoundry.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class EssenceItem extends Item {

    private String fulltip = "";

    public EssenceItem(Settings settings) {
        super(settings);
    }

    public void addToTooltip(String string) {
        fulltip += string;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("Has a 5% chance to drop from the respective mob.").formatted(Formatting.LIGHT_PURPLE));
        } else {
            tooltip.add(Text.translatable("Hold Shift for info.").formatted(Formatting.DARK_PURPLE));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
