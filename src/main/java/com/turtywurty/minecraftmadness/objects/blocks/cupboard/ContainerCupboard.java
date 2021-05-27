package com.turtywurty.minecraftmadness.objects.blocks.cupboard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ContainerCupboard extends Container
{
	private final int numRows;
	private final TileEntityCupboard chestInventory;
	
	public ContainerCupboard(InventoryPlayer playerInv, TileEntityCupboard chestInventory, EntityPlayer player) 
	{
		this.chestInventory = chestInventory;
		this.numRows = chestInventory.getSizeInventory() / 5;
		chestInventory.openInventory(player);
		
		for(int i = 0; i < this.numRows; ++i)
		{
			for(int j = 0; j < 5; ++j)
			{
				this.addSlotToContainer(new Slot(chestInventory, j + i * 5, 44 + j * 18, 18 + i * 18)
				{
					@Override
					public boolean isItemValid(ItemStack stack) 
					{
						return (stack.getItem() instanceof ItemFood);
					}
				});
			}
		}
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 141 + y * 18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 199));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return this.chestInventory.isUsableByPlayer(playerIn);
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn) 
	{
		super.onContainerClosed(playerIn);
		chestInventory.closeInventory(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.numRows * 5)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 5, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 5, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
	}
	
	public TileEntityCupboard getChestInventory() 
	{
		return this.chestInventory;
	}
}
