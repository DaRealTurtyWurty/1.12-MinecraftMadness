package com.turtywurty.minecraftmadness.objects.items.spawn_eggs;

import javax.annotation.Nullable;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.entity.frog.EntityFrog;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFrogSpawnEgg extends Item implements IHasModel
{
	public ItemFrogSpawnEgg(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ, Block block, ItemStack stack, IBlockState state) 
	{
		if (worldIn.isRemote)
        {
            return EnumActionResult.SUCCESS;
        }
		
		else if (!player.canPlayerEdit(pos.offset(facing), facing, stack))
        {
            return EnumActionResult.FAIL;
        }
			if(block != Blocks.MOB_SPAWNER)
			{
				worldIn.spawnEntity(new EntityFrog(worldIn));
				if (!player.capabilities.isCreativeMode)
                {
                    stack.shrink(1);
                }
			}
			
			if (block == Blocks.MOB_SPAWNER)
            {
                TileEntity tileentity = worldIn.getTileEntity(pos);

                if (tileentity instanceof TileEntityMobSpawner)
                {
                    MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic();
                    mobspawnerbaselogic.setEntityId(getNamedIdFrom(stack));
                    tileentity.markDirty();
                    worldIn.notifyBlockUpdate(pos, state, state, 3);

                    if (!player.capabilities.isCreativeMode)
                    {
                        stack.shrink(1);
                    }

                    return EnumActionResult.SUCCESS;
                }
		}
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	
	@Nullable
    public static ResourceLocation getNamedIdFrom(ItemStack stack)
    {
		NBTTagCompound nbttagcompound = stack.getTagCompound();

        if (nbttagcompound == null)
        {
            return null;
        }
        else if (!nbttagcompound.hasKey("EntityTag", 10))
        {
            return null;
        }
        else
        {
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("EntityTag");

            if (!nbttagcompound1.hasKey("id", 8))
            {
                return null;
            }
            else
            {
                String s = nbttagcompound1.getString("id");
                ResourceLocation resourcelocation = new ResourceLocation(s);

                if (!s.contains(":"))
                {
                    nbttagcompound1.setString("id", resourcelocation.toString());
                }

                return resourcelocation;
            }
        }
    }

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
