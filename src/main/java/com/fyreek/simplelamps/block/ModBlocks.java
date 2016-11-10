package com.fyreek.simplelamps.block;

import com.fyreek.simplelamps.SimpleLamps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Fyreek on 26.10.2016.
 */
public class ModBlocks {

    public static BlockBase basicLampBlock;
    public static BlockBase flatWallLampBlock;

    public static void preInit() {

        basicLampBlock = new BlockBasicLamp("basiclamp_block");
        flatWallLampBlock = new BlockFlatWallLamp("flatwalllamp_block");

        registerBlocks();
    }

    public static void registerBlocks() {
        registerBlock(basicLampBlock, "basiclamp_block");
        registerBlock(flatWallLampBlock, "flatwalllamp_block");
    }

    public static void registerBlock(BlockBase block, String name) {
        GameRegistry.register(block, new ResourceLocation(SimpleLamps.MODID, name));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(SimpleLamps.MODID, name));
    }

    public static void registerRenders() {
        registerRender(basicLampBlock);
        registerRender(flatWallLampBlock);
    }

    public static void registerRender(BlockBase block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
