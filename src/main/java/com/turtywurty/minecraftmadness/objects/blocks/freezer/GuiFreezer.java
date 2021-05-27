package com.turtywurty.minecraftmadness.objects.blocks.freezer;

import com.turtywurty.minecraftmadness.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiFreezer extends GuiContainer
{
	private static final ResourceLocation GUI_FREEZER = new ResourceLocation(Reference.MOD_ID + ":textures/gui/freezer.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityFreezer te;
	
	public GuiFreezer(InventoryPlayer playerInventory, TileEntityFreezer chestInventory, EntityPlayer player) 
	{
		super(new ContainerFreezer(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 179;
		this.ySize = 256;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 000000);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 000000);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_FREEZER);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}	
}