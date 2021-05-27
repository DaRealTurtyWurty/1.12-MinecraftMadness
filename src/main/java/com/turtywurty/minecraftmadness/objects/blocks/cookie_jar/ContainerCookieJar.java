package com.turtywurty.minecraftmadness.objects.blocks.cookie_jar;

import com.turtywurty.minecraftmadness.objects.blocks.cupboard.TileEntityCupboard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ContainerCookieJar extends Container
{
	private final TileEntityCookieJar jarInventory;
	
	public ContainerCookieJar(InventoryPlayer playerInv, TileEntityCookieJar jarInventory, EntityPlayer player) 
	{
		this.jarInventory = jarInventory;
		jarInventory.openInventory(player);
		int i = 51;
		
		this.addSlotToContainer(new Slot(jarInventory, 0, 80, 4)
		{
			@Override
			public boolean isItemValid(ItemStack stack) 
			{
				if(stack.getItem() == Items.COOKIE)
				{
					return true;
				}
				return false;
			}
		});
		for(int k = 0; k < 7; k++)
		{
			this.addSlotToContainer(new Slot(jarInventory, k + 1, 26 + 18 * k, 22)
			{
				@Override
				public boolean isItemValid(ItemStack stack) 
				{
					if(stack.getItem() == Items.COOKIE)
					{
						return true;
					}
					return false;
				}
			});
		}
		
		for (int l = 0; l < 3; ++l)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(playerInv, k + l * 9 + 9, 8 + k * 18, l * 18 + 51));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1)
        {
            this.addSlotToContainer(new Slot(playerInv, i1, 8 + i1 * 18, 109));
        }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return this.jarInventory.isUsableByPlayer(playerIn);
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn) 
	{
		super.onContainerClosed(playerIn);
		jarInventory.closeInventory(playerIn);
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

            if (index < this.jarInventory.getSizeInventory())
            {
                if (!this.mergeItemStack(itemstack1, this.jarInventory.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.jarInventory.getSizeInventory(), false))
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
	
	public TileEntityCookieJar getChestInventory() 
	{
		return this.jarInventory;
	}
}
