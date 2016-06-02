package net.metalforge.mod.compat.nei;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import codechicken.core.TaskProfiler;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IRecipeHandler;
import codechicken.nei.recipe.ProfilerRecipeHandler;

public class GuiMetalworkingRecipe extends GuiRecipe
{
    public static boolean openRecipeGui(String outputId, Object... results) {
        Minecraft mc = NEIClientUtils.mc();
        GuiContainer prevscreen = mc.currentScreen instanceof GuiContainer ? (GuiContainer) mc.currentScreen : null;

        TaskProfiler profiler = ProfilerRecipeHandler.getProfiler();
        ArrayList<ICraftingHandler> handlers = new ArrayList<ICraftingHandler>();
        for (ICraftingHandler craftinghandler : craftinghandlers) {
            profiler.start(craftinghandler.getRecipeName());
            ICraftingHandler handler = craftinghandler.getRecipeHandler(outputId, results);
            if (handler.numRecipes() > 0)
                handlers.add(handler);
        }
        profiler.end();
        if (handlers.isEmpty())
            return false;

        mc.displayGuiScreen(new GuiMetalworkingRecipe(prevscreen, handlers));
        return true;
    }

    private GuiMetalworkingRecipe(GuiContainer prevgui, ArrayList<ICraftingHandler> handlers) {
        super(prevgui);
        currenthandlers = handlers;
    }

    public static void registerRecipeHandler(ICraftingHandler handler) {
        for (ICraftingHandler handler1 : craftinghandlers)
            if (handler1.getClass() == handler.getClass())
                return;

        craftinghandlers.add(handler);
    }

    public ArrayList<? extends IRecipeHandler> getCurrentRecipeHandlers() {
        return currenthandlers;
    }

    public ArrayList<ICraftingHandler> currenthandlers;

    public static ArrayList<ICraftingHandler> craftinghandlers = new ArrayList<ICraftingHandler>();
}
