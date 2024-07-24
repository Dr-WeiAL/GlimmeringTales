package dev.xkmc.glimmeringtales.compat;

import dev.xkmc.glimmeringtales.content.recipe.StrikeBlockRecipe;
import dev.xkmc.glimmeringtales.init.GlimmeringTales;
import dev.xkmc.l2complements.content.recipe.DiffusionRecipe;
import dev.xkmc.l2complements.init.L2Complements;
import dev.xkmc.l2complements.init.data.LangData;
import dev.xkmc.l2complements.init.registrate.LCItems;
import dev.xkmc.l2core.compat.jei.BaseRecipeCategory;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class StrikeBlockRecipeCategory extends BaseRecipeCategory<StrikeBlockRecipe, StrikeBlockRecipeCategory> {

	protected static final ResourceLocation BG = GlimmeringTales.loc("textures/jei/background.png");

	public StrikeBlockRecipeCategory() {
		super(GlimmeringTales.loc("strike_block"), StrikeBlockRecipe.class);
	}

	public StrikeBlockRecipeCategory init(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(BG, 0, 18, 90, 18);
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, Items.TRIDENT.getDefaultInstance());
		return this;
	}

	@Override
	public Component getTitle() {
		return LangData.IDS.DIFFUSE_TITLE.get();
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, StrikeBlockRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addItemStack(recipe.ingredient.asItem().getDefaultInstance());
		builder.addSlot(RecipeIngredientRole.OUTPUT, 55, 1).addItemStack(recipe.transformTo.asItem().getDefaultInstance());
		builder.addSlot(RecipeIngredientRole.OUTPUT, 73, 1).addItemStack(recipe.result);
	}

}
