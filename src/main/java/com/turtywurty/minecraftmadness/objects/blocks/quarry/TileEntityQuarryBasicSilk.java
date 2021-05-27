package com.turtywurty.minecraftmadness.objects.blocks.quarry;

import static com.turtywurty.minecraftmadness.util.helpers.NBTHelper.toNBT;

import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityQuarryBasicSilk extends TileEntity implements ITickable 
{
	public int x, y, z, tick;
	boolean initalized = false;

	@Override
	public void update() 
	{
		if (!initalized)
			init();

		tick++;
		if (tick == 40) 
		{
			tick = 0;
			if (y > 10)
				execute();
		}
	}

	private void execute() 
	{
		int index = 0;
		Block[] blocksRemoved = new Block[9];
		for (int x = 0; x < 3; x++) 
		{
			for (int z = 0; z < 3; z++) 
			{
				BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
				blocksRemoved[index] = this.world.getBlockState(posToBreak).getBlock();
				world.setBlockToAir(posToBreak);
				index++;
			}
		}

		for (Block block : blocksRemoved) 
		{
			if (!world.isRemote)
			{
				if(block == Blocks.STONE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(Blocks.COBBLESTONE));
				}
				if(block == Blocks.GRASS)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(Blocks.DIRT));
				}
				if(block == Blocks.DIAMOND_ORE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(Items.DIAMOND));
				}
				if(block == Blocks.COAL_ORE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(Items.COAL));
				}
				if(block == Blocks.REDSTONE_ORE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(Items.REDSTONE));
				}	
				if(block == Blocks.EMERALD_ORE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(Items.EMERALD));
				}
				if(block == Blocks.QUARTZ_ORE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(Items.QUARTZ));
				}
				if(block == BlockInit.RUBY_ORE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(ItemInit.RUBY));
				}
				if(block == BlockInit.AMETHYST_ORE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(ItemInit.AMETHYST));
				}
				if(block == BlockInit.SAPPHIRE_ORE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(ItemInit.SAPPHIRE));
				}
				if(block == Blocks.LEAVES)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.TALLGRASS)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.MOB_SPAWNER)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.CHORUS_FLOWER)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.RED_FLOWER)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}	
				if(block == Blocks.YELLOW_FLOWER)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.BOOKSHELF)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.BARRIER)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.CAKE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.BEETROOTS)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.CARROTS)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}	
				if(block == Blocks.CHORUS_PLANT)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.COCOA)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.END_PORTAL_FRAME)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.END_PORTAL)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.FARMLAND)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.GLOWSTONE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, new ItemStack(Items.GLOWSTONE_DUST));
				}
				if(block == Blocks.ICE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.LIT_FURNACE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}	
				if(block == Blocks.LIT_REDSTONE_ORE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.MELON_STEM)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.MONSTER_EGG)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.NETHER_WART)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.POTATOES)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, new ItemStack(Items.POTATO));
				}	
				if(block == Blocks.TRIPWIRE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.WHEAT)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, new ItemStack(Items.WHEAT_SEEDS));
				}
				if(block == Blocks.DOUBLE_STONE_SLAB)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}	
				if(block == Blocks.DOUBLE_STONE_SLAB2)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.DOUBLE_WOODEN_SLAB)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.PURPUR_DOUBLE_SLAB)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				if(block == Blocks.FIRE)
				{
					InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY(), this.z + 1, ItemStack.EMPTY);
				}
				InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(block));
			}
		}
		this.y--;
	}

	private void init() 
	{
		initalized = true;
		x = this.pos.getX() - 1;
		y = this.pos.getY() - 1;
		z = this.pos.getZ() - 1;
		tick = 0;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		compound.setTag("initvalues", toNBT(this));
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		NBTTagCompound initValues = compound.getCompoundTag("initvalues");
		if(initValues != null) 
		{
			this.x = initValues.getInteger("x");
			this.y = initValues.getInteger("y");
			this.z = initValues.getInteger("z");
			this.tick = 0;
			initalized = true;
			return;
		}
		init();
	}
}
