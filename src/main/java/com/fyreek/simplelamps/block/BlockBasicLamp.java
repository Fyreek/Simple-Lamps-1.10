package com.fyreek.simplelamps.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by Fyreek on 26.10.2016.
 */
public class BlockBasicLamp extends BlockBase {

    public BlockBasicLamp(String name) {
        super(Material.REDSTONE_LIGHT, name);
        setHardness(2.0F);
        setResistance(10F);
        setSoundType(SoundType.GLASS);
        setLightLevel(1F);
    }
}
