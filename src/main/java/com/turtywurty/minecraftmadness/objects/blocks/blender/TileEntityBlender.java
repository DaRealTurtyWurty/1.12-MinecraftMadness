package com.turtywurty.minecraftmadness.objects.blocks.blender;

import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityBlender extends TileEntity implements IInventory, ITickable
{
	private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
	private String customName;
	
	private int blendTime;
	private int currentBlendTime;
	private int blendingTime;
	private int totalBlendingTime;
	public int progress;
	public long cycle;
	
	@Override
	public String getName() 
	{
		return this.hasCustomName() ? this.customName : "container.blender";
	}

	@Override
	public boolean hasCustomName() 
	{
		return this.customName != null && !this.customName.isEmpty();
	}
	
	public void setCustomName(String customName) 
	{
		this.customName = customName;
	}
	
	@Override
	public ITextComponent getDisplayName() 
	{
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() 
	{
		return this.inventory.size();
	}

	@Override
	public boolean isEmpty() 
	{
		for(ItemStack stack : this.inventory)
		{
			if(!stack.isEmpty()) return false;
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return (ItemStack)this.inventory.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return ItemStackHelper.getAndSplit(this.inventory, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(this.inventory, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		ItemStack itemstack = (ItemStack)this.inventory.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.inventory.set(index, stack);
		
		if(stack.getCount() > this.getInventoryStackLimit()) stack.setCount(this.getInventoryStackLimit());
		if(index == 0 && index + 1 == 1 && !flag)
		{
			ItemStack stack1 = (ItemStack)this.inventory.get(index + 1);
			this.totalBlendingTime = this.getBlendingTime(stack, stack1);
			this.blendingTime = 0;
			this.markDirty();
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.inventory);
		this.blendTime = compound.getInteger("BlendTime");
		this.blendingTime = compound.getInteger("BlendingTime");
		this.totalBlendingTime = compound.getInteger("BlendingTimeTotal");
		this.currentBlendTime = getItemBlendTime((ItemStack)this.inventory.get(2));
		
		if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		compound.setInteger("BlendTime", (short)this.blendTime);
		compound.setInteger("BlendingTime", (short)this.blendingTime);
		compound.setInteger("BlendingTimeTotal", (short)this.totalBlendingTime);
		ItemStackHelper.saveAllItems(compound, this.inventory);
		
		if(this.hasCustomName()) compound.setString("CustomName", this.customName);
		return compound;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	public boolean isBlending() 
	{
		return this.blendTime > 0;
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean isBlending(IInventory inventory) 
	{
		return inventory.getField(0) > 0;
	}
	
	public void update() 
	{
		if(this.isBlending() && this.cycle % 6 == 0)
		{
			++this.progress;
		}
		
		boolean flag = this.isBlending();
		boolean flag1 = false;
		
		if(this.isBlending()) --this.blendTime;
		
		if(!this.world.isRemote) 
		{
			ItemStack stack = (ItemStack)this.inventory.get(2);
			
			if(this.isBlending() || !stack.isEmpty() && !((((ItemStack)this.inventory.get(0)).isEmpty()) || ((ItemStack)this.inventory.get(1)).isEmpty())) 
			{
				if(!this.isBlending() && this.canSmelt()) 
				{
					this.blendTime = getItemBlendTime(stack);
					this.currentBlendTime = this.blendTime;
					
					if(this.isBlending()) 
					{
						flag1 = true;
						
						if(!stack.isEmpty()) 
						{
							Item item = stack.getItem();
							stack.shrink(1);
							
							if(stack.isEmpty()) 
							{
								ItemStack item1 = item.getContainerItem(stack);
								this.inventory.set(2, item1);
							}
						}
					}
				} 
				if(this.isBlending() && this.canSmelt()) 
				{
					++this.blendingTime;
					
					if(this.blendingTime == this.totalBlendingTime) 
					{
						this.blendingTime = 0;
						this.totalBlendingTime = this.getBlendingTime((ItemStack)this.inventory.get(0), (ItemStack)this.inventory.get(1));
						this.smeltItem();
						flag1 = true;
					}
				} 
				else this.blendingTime = 0;
			} 
			else if(!this.isBlending() && this.blendingTime > 0) 
			{
				this.blendingTime = MathHelper.clamp(this.blendingTime - 2, 0, this.totalBlendingTime);
			}
			if(flag != this.isBlending()) 
			{
				flag1 = true;
				BlenderBlock.setState(this.isBlending(), this.world, this.pos);
			}
		} 
		if(flag1) this.markDirty();
	}
	
	public int getBlendingTime(ItemStack input1, ItemStack input2) 
	{
		return 200;
	}
	
	private boolean canSmelt() 
	{
		if(((ItemStack)this.inventory.get(0)).isEmpty() || ((ItemStack)this.inventory.get(1)).isEmpty()) return false;
		else 
		{
			ItemStack result = BlenderRecipes.getInstance().getBlendingResult((ItemStack)this.inventory.get(0), (ItemStack)this.inventory.get(1));	
			if(result.isEmpty()) return false;
			else
			{
				ItemStack output = (ItemStack)this.inventory.get(3);
				if(output.isEmpty()) return true;
				if(!output.isItemEqual(result)) return false;
				int res = output.getCount() + result.getCount();
				return res <= getInventoryStackLimit() && res <= output.getMaxStackSize();
			}
		}
	}
	
	public void smeltItem() 
	{
		if(this.canSmelt()) 
		{
			ItemStack input1 = (ItemStack)this.inventory.get(0);
			ItemStack input2 = (ItemStack)this.inventory.get(1);
			ItemStack result = BlenderRecipes.getInstance().getBlendingResult(input1, input2);
			ItemStack output = (ItemStack)this.inventory.get(3);
			
			if(output.isEmpty()) this.inventory.set(3, result.copy());
			else if(output.getItem() == result.getItem()) output.grow(result.getCount());
			
			input1.shrink(1);
			input2.shrink(1);
		}
	}
	
	public static int getItemBlendTime(ItemStack cup) 
	{
		if(cup.isEmpty()) return 0;
		else 
		{
			Item item = cup.getItem();
			if(item == ItemInit.CUP)
			{
				return 200;
			}
			else
			{
				return 0;
			}
		}
	}
		
	public static boolean isItemCup(ItemStack cup)
	{
		return getItemBlendTime(cup) > 0;
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		
		if(index == 3) return false;
		else if(index != 2) return true;
		else 
		{
			return isItemCup(stack);
		}
	}
	
	public String getGuiID() 
	{
		return "minecraftmadness:blender";
	}

	@Override
	public int getField(int id) 
	{
		switch(id) 
		{
		case 0:
			return this.blendTime;
		case 1:
			return this.currentBlendTime;
		case 2:
			return this.blendingTime;
		case 3:
			return this.totalBlendingTime;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) 
	{
		switch(id) 
		{
		case 0:
			this.blendTime = value;
			break;
		case 1:
			this.currentBlendTime = value;
			break;
		case 2:
			this.blendingTime = value;
			break;
		case 3:
			this.totalBlendingTime = value;
		}
	}

	@Override
	public int getFieldCount() 
	{
		return 4;
	}

	@Override
	public void clear() 
	{
		this.inventory.clear();
	}
}
