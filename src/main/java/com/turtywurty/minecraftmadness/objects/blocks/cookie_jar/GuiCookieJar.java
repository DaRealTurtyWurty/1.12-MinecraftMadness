package com.turtywurty.minecraftmadness.objects.blocks.cookie_jar;

import com.turtywurty.minecraftmadness.objects.blocks.cupboard.TileEntityCupboard;
import com.turtywurty.minecraftmadness.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiCookieJar extends GuiContainer
{
	private static final ResourceLocation GUI_COOKIE_JAR = new ResourceLocation(Reference.MOD_ID + ":textures/gui/cookie_jar.png");
	private final InventoryPlayer playerInv;
	private final TileEntityCookieJar te;
	
	public GuiCookieJar(InventoryPlayer playerInv, TileEntityCookieJar jarInv, EntityPlayer player) 
	{
		super(new ContainerCookieJar(playerInv, jarInv, player));
		this.playerInv = playerInv;
		this.te = jarInv;
		
		this.xSize = 175;
		this.ySize = 132;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 000000);
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 000000);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_COOKIE_JAR);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
