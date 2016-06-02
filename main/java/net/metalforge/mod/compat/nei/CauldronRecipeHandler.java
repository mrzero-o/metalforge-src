package net.metalforge.mod.compat.nei;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.metalforge.mod.crafting.CauldronRecipes;
import net.metalforge.mod.inventory.gui.GuiCauldron;
import net.metalforge.mod.random.StringUtil;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;

public class CauldronRecipeHandler extends TemplateRecipeHandler
{
    public class CoolingPair extends CachedRecipe
    {
        public CoolingPair(ItemStack ingred, ItemStack result) {
            ingred.stackSize = 1;
            this.ingred = new PositionedStack(ingred, 51, 6);
            this.result = new PositionedStack(result, 111, 24);
        }

        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred));
        }

        public PositionedStack getResult() {
            return result;
        }

        PositionedStack ingred;
        PositionedStack result;
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiCauldron.class;
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(61, 25, 20, 18), "cauldron"));
    }

    @Override
    public String getRecipeName() {
        return StringUtil.getCauldronGuiName();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if(outputId.equals("cauldron") && getClass() == CauldronRecipeHandler.class) {
        	Map<ItemStack, ItemStack> recipes = (Map<ItemStack, ItemStack>) CauldronRecipes.cooling().getCoolingList();
            for(Entry<ItemStack, ItemStack> recipe : recipes.entrySet()){
                arecipes.add(new CoolingPair(recipe.getKey(), recipe.getValue()));
            }
        }else super.loadCraftingRecipes(outputId, results);
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
	    Map<ItemStack, ItemStack> recipes = (Map<ItemStack, ItemStack>) CauldronRecipes.cooling().getCoolingList();
	    for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
	        if (NEIServerUtils.areStacksSameType(recipe.getValue(), result))
	            arecipes.add(new CoolingPair(recipe.getKey(), recipe.getValue()));
        
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients) {
        if(inputId == "cauldron" && getClass() == CauldronRecipeHandler.class) loadCraftingRecipes("cauldron");
        else super.loadUsageRecipes(inputId, ingredients);
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        Map<ItemStack, ItemStack> recipes = (Map<ItemStack, ItemStack>) CauldronRecipes.cooling().getCoolingList();
        for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
            if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) {
            	CoolingPair arecipe = new CoolingPair(recipe.getKey(), recipe.getValue());
                arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
                arecipes.add(arecipe);
            }
    }

    @Override
    public String getGuiTexture() {
        return GuiCauldron.getTextureName();
    }

    @Override
    public String getOverlayIdentifier() {
        return "cauldron";
    }
}