package com.fyreek.simplelamps.block;

import com.fyreek.simplelamps.SimpleLamps;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

/**
 * Created by Fyreek on 26.10.2016.
 */
public class BlockBase extends Block {

    public BlockBase(Material materialIn, String name) {
        super(materialIn);
        setUnlocalizedName(name);
        setDefaultState(pickDefaultState());
        if (registerInCreative())
            setCreativeTab(SimpleLamps.tabCreative);
    }

    public IBlockState pickDefaultState() {
        return blockState.getBaseState();
    }

    protected boolean registerInCreative() {
        return true;
    }
}
