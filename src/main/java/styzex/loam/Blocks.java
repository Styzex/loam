package styzex.loam;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Blocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the "loam" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Loam.MODID);
    // Creates a new Block with the id "loam:example_block", combining the namespace and path
    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", p -> p.mapColor(MapColor.STONE));
    // Creates a new BlockItem with the id "loam:example_block", combining the namespace and path
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = Items.ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    // Add the example block item to the building blocks tab
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(styzex.loam.Blocks.EXAMPLE_BLOCK_ITEM);
        }
    }
}
