package com.styzex.loam;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

public class VanillaFoodItems {
    public static final float SAT_MOD_POOR = 0.1F;
    public static final float SAT_MOD_LOW = 0.3F;
    public static final float SAT_MOD_NORMAL = 0.6F;
    public static final float SAT_MOD_GOOD = 0.8F;
    public static final float SAT_MOD_MAX = 1.0F;

    private static void modifyFood(ModifyDefaultComponentsEvent event, net.minecraft.world.level.ItemLike item,
            int nutrition, float saturationModifier, boolean alwaysEdible) {
        event.modify(item, (builder, _, _) -> {
            FoodProperties.Builder foodBuilder = new FoodProperties.Builder()
                    .nutrition(nutrition)
                    .saturationModifier(saturationModifier);

            if (alwaysEdible) {
                foodBuilder.alwaysEdible();
            }

            builder.set(DataComponents.FOOD, foodBuilder.build());
        });
    }

    // Saturation formula: nutrition * sat_modifier * 2 = saturation
    public static void ModifyFoods(ModifyDefaultComponentsEvent event) {
        modifyFood(event, Items.APPLE, 2, SAT_MOD_LOW, false);
        modifyFood(event, Items.BAKED_POTATO, 4, SAT_MOD_NORMAL, false);
        modifyFood(event, Items.BEEF, 3, SAT_MOD_LOW, false);
        modifyFood(event, Items.BEETROOT_SOUP, 5, SAT_MOD_NORMAL, false);
        modifyFood(event, Items.BREAD, 5, SAT_MOD_NORMAL, false);
        modifyFood(event, Items.CARROT, 3, SAT_MOD_NORMAL, false);
        modifyFood(event, Items.CHICKEN, 1, SAT_MOD_LOW, false);
        modifyFood(event, Items.CHORUS_FRUIT, 4, SAT_MOD_LOW, true);
        modifyFood(event, Items.COD, 2, SAT_MOD_POOR, false);
        modifyFood(event, Items.COOKED_BEEF, 5, SAT_MOD_GOOD, false);
        modifyFood(event, Items.COOKED_CHICKEN, 5, SAT_MOD_NORMAL, false);
        modifyFood(event, Items.COOKED_COD, 4, SAT_MOD_NORMAL, false);
        modifyFood(event, Items.COOKED_MUTTON, 4, SAT_MOD_GOOD, false);
        modifyFood(event, Items.COOKED_PORKCHOP, 5, SAT_MOD_GOOD, false);
        modifyFood(event, Items.COOKED_RABBIT, 5, SAT_MOD_NORMAL, false);
        modifyFood(event, Items.COOKED_SALMON, 4, SAT_MOD_GOOD, false);
        modifyFood(event, Items.COOKIE, 2, SAT_MOD_POOR, false);
        modifyFood(event, Items.DRIED_KELP, 1, SAT_MOD_LOW, false);
        modifyFood(event, Items.ENCHANTED_GOLDEN_APPLE, 5, SAT_MOD_MAX, true);
        modifyFood(event, Items.GOLDEN_APPLE, 5, SAT_MOD_MAX, true);
        modifyFood(event, Items.GOLDEN_CARROT, 5, SAT_MOD_GOOD, false);
        modifyFood(event, Items.HONEY_BOTTLE, 4, SAT_MOD_LOW, true);
        modifyFood(event, Items.MELON_SLICE, 2, SAT_MOD_LOW, false);
        modifyFood(event, Items.MUSHROOM_STEW, 4, SAT_MOD_NORMAL, false);
        modifyFood(event, Items.MUTTON, 2, SAT_MOD_LOW, true);
        modifyFood(event, Items.POISONOUS_POTATO, 2, SAT_MOD_LOW, false);
        modifyFood(event, Items.PORKCHOP, 3, SAT_MOD_LOW, false);
        modifyFood(event, Items.POTATO, 1, SAT_MOD_LOW, false);
        modifyFood(event, Items.PUFFERFISH, 1, SAT_MOD_POOR, false);
        modifyFood(event, Items.PUMPKIN_PIE, 6, SAT_MOD_LOW, false);
        modifyFood(event, Items.RABBIT, 3, SAT_MOD_LOW, false);
        modifyFood(event, Items.RABBIT_STEW, 6, SAT_MOD_MAX, false);
        modifyFood(event, Items.ROTTEN_FLESH, 4, SAT_MOD_POOR, false);
        modifyFood(event, Items.SALMON, 2, SAT_MOD_POOR, false);
        modifyFood(event, Items.SPIDER_EYE, 2, SAT_MOD_GOOD, false);
        modifyFood(event, Items.SUSPICIOUS_STEW, 6, SAT_MOD_NORMAL, true);
        modifyFood(event, Items.SWEET_BERRIES, 2, SAT_MOD_POOR, false);
        modifyFood(event, Items.GLOW_BERRIES, 2, SAT_MOD_POOR, false);
        modifyFood(event, Items.TROPICAL_FISH, 1, SAT_MOD_LOW, false);
    }
}
