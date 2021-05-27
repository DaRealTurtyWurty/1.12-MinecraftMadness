package com.turtywurty.minecraftmadness.objects.items.mod_book;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.turtywurty.minecraftmadness.util.Reference;
import com.turtywurty.minecraftmadness.util.handlers.SoundsHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBookGui extends GuiScreen 
{
	private final int bookImageHeight = 210;
	private final int bookImageWidth = 256;
	private int currPage = 0;
	private int Scale;
	Random rand = new Random();
	private GuiButton buttonDone;
	private NumbSelctor VolSelectorM;
	private NumbSelctor VolSelectorG;
	private NumbSelctor VolSelectorA;
	private NextPageButton buttonNextPage;
	private NextPageButton buttonNextPageF;
	private NextPageButton buttonPreviousPage;
	private VolumeArrows volumeNextPage1;
	private VolumeArrows volumePreviousPage1;
	private VolumeArrows volumeNextPage2;
	private VolumeArrows volumePreviousPage2;
	private VolumeArrows volumeNextPage3;
	private VolumeArrows volumePreviousPage3;
	private WhatThisButton buttonWhatThis;
	private ButtonMagnifier magButton;
	protected FontRenderer customFontRenderer; 
	
	private static ResourceLocation next_buttons = new ResourceLocation(Reference.MOD_ID + ":textures/gui/modbook/page_c.png");
    private static ResourceLocation index = new ResourceLocation(Reference.MOD_ID + ":textures/gui/modbook/index.png");
    private static final ResourceLocation BOOK_GUI_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/modbook/turn_buttons.png");
    
    private static ResourceLocation STATS = new ResourceLocation(Reference.MOD_ID + ":textures/gui/modbook/icon/stats_icons.png");
    private static ResourceLocation MARK = new ResourceLocation(Reference.MOD_ID + ":textures/gui/modbook/ribbon/bookmark3.png");
    private static ResourceLocation STAGE = new ResourceLocation(Reference.MOD_ID + ":textures/gui/modbook/ribbon/bookmark1.png");
    
    private static final int bookTotalPages = 10;
    private boolean pageUnlocked[] = new boolean[bookTotalPages + 1];
    private boolean pageRipped[] = new boolean[bookTotalPages + 1];
    private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static String[] stringPageText = new String[bookTotalPages];
	private static String[] stringPageText2 = new String[bookTotalPages];
	private static String[] typeStringsE = new String[10];
	
	boolean flip = false;
	int nextButtonBack = 233;
    private ItemStack stack;
    private boolean zoomed = false;
    
    public ModBookGui(ItemStack stack)
    {
    	this.stack = stack;
    }
    
    @Override
    public void initGui() 
    {
    	NBTTagCompound nbt = stack.getTagCompound();
    	if(nbt == null) 
    	{
		    nbt = new NBTTagCompound();
		}
    	
		nbt = nbt.getCompoundTag("pages");
		int unlocked_pages = 0; 
		if(nbt.hasKey("unlocked_pages"))
		{
		    unlocked_pages = nbt.getInteger("unlocked_pages");
		}
		
		for(int i = 1; i <= bookTotalPages; i++)
		{
			pageUnlocked[i] = false; 
            if(nbt.hasKey("page_" + i)) 
            {
                if(nbt.getBoolean("page_" + i));
                {
                    pageUnlocked[i] = true;     
                }
            }
		}
		buttonList.clear();

        Keyboard.enableRepeatEvents(true);
        
        buttonDone = new GuiButton(0, width / 2 - 50, -15 + bookImageHeight, 98, 20, I18n.format("gui.done", new Object[0])) 
        {
        	@Override
        	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
            {
        		GL11.glColor4f(7.0F, 1.0F, 1.0F, 1.0F);
        		super.drawButton(mc, mouseX, mouseY, partialTicks);
            }

        	@Override
        	public void playPressSound(SoundHandler soundHandlerIn)
            {
                soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(SoundsHandler.BOOK_CLOSE, 1.0F));
            }
        };
        buttonList.add(buttonDone);
       
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + nextButtonBack + 21, 178, true));
        buttonList.add(buttonNextPageF = new NextPageButton(1, offsetFromScreenLeft + 175, 175, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, offsetFromScreenLeft - 25, 178, false));
        buttonList.add(VolSelectorM = new NumbSelctor(2, offsetFromScreenLeft + 100, 60, 45, false));
        buttonList.add(VolSelectorG = new NumbSelctor(2, offsetFromScreenLeft + 100, 101, 45, true));
        buttonList.add(VolSelectorA = new NumbSelctor(2, offsetFromScreenLeft + 100, 142, 45, true));
        buttonList.add(buttonWhatThis = new WhatThisButton(2, offsetFromScreenLeft + 192, 37));
        buttonList.add(volumeNextPage1 = new VolumeArrows(2, offsetFromScreenLeft - 14, 10, true, 46));
        buttonList.add(volumeNextPage2 = new VolumeArrows(2, offsetFromScreenLeft - -10, 10, true, 91));
        buttonList.add(volumeNextPage3 = new VolumeArrows(2, offsetFromScreenLeft - -34, 10, true, 136));
        buttonList.add(volumePreviousPage1 = new VolumeArrows(2, offsetFromScreenLeft - 14, 10, false, 46));
        buttonList.add(magButton = new ButtonMagnifier(777, offsetFromScreenLeft - -49, 80, zoomed, 136));
        buttonNextPage.visible = false;
		buttonPreviousPage.visible = false;
		VolSelectorA.visible = currPage == 1;
		VolSelectorG.visible = currPage == 1;
        VolSelectorM.visible = currPage == 1;
        volumeNextPage1.visible = currPage > 0 && currPage < 2;
        volumePreviousPage1.visible = currPage > 2 && currPage < 46;
        volumeNextPage2.visible = currPage > 0 && currPage < 47;
        volumeNextPage3.visible = currPage > 0;
        magButton.visible = currPage < 42 && currPage >= 24;
    }  
    boolean showMe = false;
	private float mousePosY;
	private float mousePosX;

	@Override
	public void updateScreen() 
	{
		buttonNextPage.visible = (currPage < bookTotalPages - 1 && currPage != 0);
 		buttonPreviousPage.visible = currPage > 0;
		buttonNextPageF.visible = currPage == 0;
		VolSelectorA.visible = currPage == 1;
		VolSelectorG.visible = currPage == 1;
        VolSelectorM.visible = currPage == 1;
        volumeNextPage1.visible = currPage > 0 && currPage < 2;
        volumePreviousPage1.visible = currPage > 2 && currPage < 47;
        volumeNextPage2.visible = currPage > 0 && currPage < 47;
        volumeNextPage3.visible = currPage > 0;
        magButton.visible = currPage < 42 && currPage >= 24;
	}
	
	@Override
    protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick) 
    {
    }
	
	

    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
    	int offsetFromScreenLeft = (width - bookImageWidth) / 2;
     if (parButton == buttonDone)
     {
         // You can send a packet to server here if you need server to do something
        
         mc.displayGuiScreen((GuiScreen)null);
     }
        else if (parButton == buttonNextPage)
        {
        	//buttonNextPage.visible = (currPage < bookTotalPages - 1 && currPage != 0);
     		//buttonPreviousPage.visible = currPage > 0;
            if (currPage < bookTotalPages - 1)
            {
                ++currPage;
            }
        }
        else if (parButton == buttonPreviousPage)
        {
        	//buttonNextPage.visible = (currPage < bookTotalPages - 1 && currPage != 0);
     		//buttonPreviousPage.visible = currPage > 0;
            if (currPage > 0)
            {
                --currPage;
            }
        }
        else if(parButton == VolSelectorG) {
        	currPage = 66;
        }
        else if(parButton == VolSelectorA) {
        	currPage = 76;
        }else if(parButton == VolSelectorM){
        	currPage = 2;
        }
        else if(parButton == buttonNextPageF){
        	currPage = 1;
        	//buttonNextPage.visible = (currPage < bookTotalPages - 1 && currPage != 0);
     		//buttonPreviousPage.visible = currPage > 0;
        }
        else if(parButton == buttonWhatThis){
        	if(showMe == false) {
        		showMe = true;
        	}else {
        		showMe = false;
        	}
        }
        else if(parButton == buttonWhatThis){
        	
        }else if(parButton == volumeNextPage1) {
        	currPage = 2;
        }
        else if(parButton == volumePreviousPage1) {
        	currPage = 2;
        }else if(parButton == magButton) {
        	if(zoomed) {
        		Scale -= 5;
        		zoomed = false;
        		magButton.isMag = false;
        	}else if(!zoomed) {
        		Scale += 5;
        		zoomed = true;
        		magButton.isMag = true;
        	}
        }
   }
	@Override
	public void onGuiClosed() 
	{
		this.flip = true;
	}
	/**
	 * Returns true if this GUI should pause the game when it is displayed in 
	 * single-player
	 */
	@Override
	public boolean doesGuiPauseGame()
	{
	    return false;
	}
	
	
	
	@SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton
    {
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
        }
       
        @Override
        public void playPressSound(SoundHandler soundHandlerIn)
        {
           soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(SoundsHandler.PAGE_FLIP , 1.2F));
        }

        /**
         * Draws this button to the screen.
         */
        @Override
        public void drawButton(Minecraft mc, int parX, int parY, float partial)
        {
            if (visible)
            {
                boolean isButtonPressed = (parX >= x && parY >= y && parX < x + width && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BOOK_GUI_TEXTURES);
                int i = 0;
                int j = 192;

                if (isButtonPressed)
                {
                    i += 23;
                }
                
                

                if (!isNextButton)
                {
                    j += 13;
                }

                this.drawTexturedModalRect(this.x, this.y, i, j, 23, 13);
            }
        }
    }
	
	@SideOnly(Side.CLIENT)
    static class NumbSelctor extends GuiButton
    {
		private static int pageNumb;
		boolean sound;
		Random rand = new Random();
        public NumbSelctor(int parButtonId, int parPosX, int parPosY, int numb, boolean soundIs)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, I18n.format("+", new Object[0])); 
            this.pageNumb = numb;
            sound = soundIs;
        }
        
        @Override
        public void playPressSound(SoundHandler soundHandlerIn) {
        	if(sound == true) {
        		soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(SoundsHandler.PAGE_FLIP, 1.2F));
        		soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(SoundsHandler.PAGE_FLIP, 1.6F));
        		soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(SoundsHandler.PAGE_FLIP, 0.15F));
        	}else {
        		soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(SoundsHandler.PAGE_FLIP, rand.nextFloat() * 1.74F));
        	}
        }
    }
	@SideOnly(Side.CLIENT)
    static class WhatThisButton extends GuiButton
    {
		boolean showBox;
		Random rand = new Random();
        public WhatThisButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, I18n.format("", new Object[0])); 
        }
        @Override
        public void drawButton(Minecraft mc, int parX, int parY, float partial)
        {
            if (visible)
            {
                boolean isButtonPressed = (parX >= x && parY >= y && parX < x + width && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                if(isButtonPressed) {
                	bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/modbook/cover/modbook_book_cover_page_open.png");
                	
                }else {
                	bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/modbook/cover/modbook_book_cover_page_closed.png");
                }
                
                if(showBox == true) {
                    //mc.getTextureManager().bindTexture(BOOK_GUI_TEXTURES);
                }
            }
        }
    }
	
	static class VolumeArrows extends GuiButton{
		
		private final boolean isNextButton;
		private final int ID;

        public VolumeArrows(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton, int buttonID)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
            ID = buttonID;
        }
		@Override
        public void drawButton(Minecraft mc, int parX, int parY, float partial)
        {
            if (visible)
            {
            	boolean isButtonPressed = (parX >= x && parY >= y && parX < x + width && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BOOK_GUI_TEXTURES);
                int i = ID;
                int j = 192;
                

                if (isButtonPressed)
                {
                    i += 23;
                }
                
                if (!isNextButton)
                {
                    j += 13;
                }

                this.drawTexturedModalRect(this.x, this.y, i, j, 23, 13);
            }
        }
	}
	static class ButtonMagnifier extends GuiButton{
		
		private boolean isMag;
        public ButtonMagnifier(int parButtonId, int parPosX, int parPosY, boolean isZoom, int buttonID)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isMag = isZoom;
        }
		@Override
        public void drawButton(Minecraft mc, int parX, int parY, float partial)
        {
            if (visible)
            {
            	boolean isButtonPressed = (parX >= x && parY >= y && parX < x + width && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BOOK_GUI_TEXTURES);
                int j = 192;
                int i = 188;

                if (isButtonPressed)
                {
                   j += 24;
                }
                
                if (isMag)
                {
                   j += 12;
                }

                this.drawTexturedModalRect(this.x, this.y, i, j, 23, 12);
            }
        }
	}
}