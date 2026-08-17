package styzex.loam;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {
    // Create a Deferred Register to hold Items which will all be registered under the "loam" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Loam.MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "loam" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Loam.MODID);


    // Creates a new food item with the id "loam:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item>  EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", p -> p.food(new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(1)
            .saturationModifier(2f)
            .build()));

    // Creates a creative tab with the id "loam:loam" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> LOAM_TAB = CREATIVE_MODE_TABS.register("loam", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.loam")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get());// Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(Blocks.EXAMPLE_BLOCK_ITEM.get());
            }).build());

}
