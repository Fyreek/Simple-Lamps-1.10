package com.fyreek.simplelamps;

import com.fyreek.simplelamps.block.ModBlocks;
import com.fyreek.simplelamps.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SimpleLamps.MODID, version = SimpleLamps.VERSION, name = SimpleLamps.NAME)
public class SimpleLamps
{
    public static final String MODID = "simplelamps";
    public static final String VERSION = "1.0";
    public static final String NAME = "Simple Lamps";

    @SidedProxy(clientSide = "com.fyreek.simplelamps.proxy.ClientProxy", serverSide = "com.fyreek.simplelamps.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static SimpleLamps instance;

    public static CreativeTab tabCreative;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        tabCreative = new CreativeTab(CreativeTabs.getNextID(), "tab_creative");
        ModBlocks.preInit();

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        proxy.postInit(event);
    }
}
