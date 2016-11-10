package com.fyreek.simplelamps.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Fyreek on 09/11/2016.
 */
public class BlockFlatWallLamp extends BlockBase {

    private static final AxisAlignedBB BOUNDING_BOX_DOWN = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 4, 0.0625 * 13);
    private static final AxisAlignedBB BOUNDING_BOX_UP = new AxisAlignedBB(0.0625 * 3, 0.0625 * 12, 0.0625 * 3, 0.0625 * 13, 1, 0.0625 * 13);
    private static final AxisAlignedBB BOUNDING_BOX_NORTH = new AxisAlignedBB(0.0625 * 3, 0.0625 * 3, 0, 0.0625 * 13, 0.0625 * 13, 0.0625 * 4);
    private static final AxisAlignedBB BOUNDING_BOX_SOUTH = new AxisAlignedBB(0.0625 * 3, 0.0625 * 3, 0.0625 * 12, 0.0625 * 13, 0.0625 * 13, 1);
    private static final AxisAlignedBB BOUNDING_BOX_WEST = new AxisAlignedBB(0, 0.0625 * 3, 0.0625 * 3, 0.0625 * 4, 0.0625 * 13, 0.0625 * 13);
    private static final AxisAlignedBB BOUNDING_BOX_EAST = new AxisAlignedBB(0.0625 * 12, 0.0625 * 3, 0.0625 * 3, 1, 0.0625 * 13, 0.0625 * 13);

    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    //public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);

    public BlockFlatWallLamp(String name) {
        super(Material.REDSTONE_LIGHT, name);
        setHardness(1.0F);
        setResistance(3F);
        setSoundType(SoundType.GLASS);
        setLightLevel(1F);
        //setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(COLOR, EnumDyeColor.WHITE));
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }



    /*@Override
    public int damageDropped(IBlockState state) {
        return state.getValue(COLOR).getMetadata();
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        for (EnumDyeColor enumdyecolor : EnumDyeColor.values()) {
            list.add(new ItemStack(itemIn, 1, enumdyecolor.getMetadata()));
        }
    }*/

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

        switch (state.getValue(FACING)) {
            case DOWN:
                return BOUNDING_BOX_DOWN;
            case UP:
            default:
                return BOUNDING_BOX_UP;
            case NORTH:
                return BOUNDING_BOX_NORTH;
            case SOUTH:
                return BOUNDING_BOX_SOUTH;
            case WEST:
                return BOUNDING_BOX_WEST;
            case EAST:
                return BOUNDING_BOX_EAST;
        }
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, state.getBoundingBox(worldIn, pos));
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, facing.getOpposite());
    }

    @Nullable
    public static EnumFacing getFacing(int meta)
    {
        int i = meta & 7;
        return i > 5 ? null : EnumFacing.getFront(i);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, getFacing(meta));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }
}
