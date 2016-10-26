package com.fyreek.simplelamps;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Fyreek on 26.10.2016.
 */
public class CreativeTab extends CreativeTabs {

    public CreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public Item getTabIconItem() {
        return Items.GLOWSTONE_DUST;
    }
}
