package com.turtywurty.minecraftmadness.init;

import java.util.ArrayList;
import java.util.List;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.objects.items.ItemBase;
import com.turtywurty.minecraftmadness.objects.items.armor.ArmorBase;
import com.turtywurty.minecraftmadness.objects.items.armor.MagmaticArmor;
import com.turtywurty.minecraftmadness.objects.items.arrows.ItemFireArrow;
import com.turtywurty.minecraftmadness.objects.items.bows.ItemLeatherBow;
import com.turtywurty.minecraftmadness.objects.items.food.ItemCookedFrogLegs;
import com.turtywurty.minecraftmadness.objects.items.food.ItemDorito;
import com.turtywurty.minecraftmadness.objects.items.food.ItemEnchantedRubyApple;
import com.turtywurty.minecraftmadness.objects.items.food.ItemGreenApple;
import com.turtywurty.minecraftmadness.objects.items.food.ItemModDrink;
import com.turtywurty.minecraftmadness.objects.items.food.ItemModFood;
import com.turtywurty.minecraftmadness.objects.items.food.ItemRice;
import com.turtywurty.minecraftmadness.objects.items.food.ItemRubyApple;
import com.turtywurty.minecraftmadness.objects.items.food.ItemSalt;
import com.turtywurty.minecraftmadness.objects.items.food.ItemSkinnedFrogLegs;
import com.turtywurty.minecraftmadness.objects.items.food.ItemTomatoSoup;
import com.turtywurty.minecraftmadness.objects.items.mod_book.ItemModBook;
import com.turtywurty.minecraftmadness.objects.items.orbs.FireResistanceOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.HasteOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.InstantHealthOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.JumpBoostOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.LevitationOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.NightVisionOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.RegenerationOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.ResistanceOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.SaturationOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.SpeedOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.StrengthOrb;
import com.turtywurty.minecraftmadness.objects.items.orbs.WaterBreathingOrb;
import com.turtywurty.minecraftmadness.objects.items.random.ItemCopperCoin;
import com.turtywurty.minecraftmadness.objects.items.random.ItemEnderShard;
import com.turtywurty.minecraftmadness.objects.items.random.ItemGoldCoin;
import com.turtywurty.minecraftmadness.objects.items.random.ItemSilverCoin;
import com.turtywurty.minecraftmadness.objects.items.random.MadnessLogo;
import com.turtywurty.minecraftmadness.objects.items.seeds.ItemLemonSeeds;
import com.turtywurty.minecraftmadness.objects.items.seeds.ItemMutatedLilyPad;
import com.turtywurty.minecraftmadness.objects.items.seeds.ItemMutatedSugarcane;
import com.turtywurty.minecraftmadness.objects.items.seeds.ItemTomatoSeeds;
import com.turtywurty.minecraftmadness.objects.items.tools.ItemKnife;
import com.turtywurty.minecraftmadness.objects.items.tools.ItemPizzaCutter;
import com.turtywurty.minecraftmadness.objects.items.tools.MagmaticAxe;
import com.turtywurty.minecraftmadness.objects.items.tools.MagmaticHoe;
import com.turtywurty.minecraftmadness.objects.items.tools.MagmaticPickaxe;
import com.turtywurty.minecraftmadness.objects.items.tools.MagmaticShovel;
import com.turtywurty.minecraftmadness.objects.items.tools.MagmaticSword;
import com.turtywurty.minecraftmadness.objects.items.tools.ToolAxe;
import com.turtywurty.minecraftmadness.objects.items.tools.ToolHoe;
import com.turtywurty.minecraftmadness.objects.items.tools.ToolPickaxe;
import com.turtywurty.minecraftmadness.objects.items.tools.ToolShovel;
import com.turtywurty.minecraftmadness.objects.items.tools.ToolSword;
import com.turtywurty.minecraftmadness.objects.items.utility.ItemBackpack;
import com.turtywurty.minecraftmadness.objects.items.utility.ItemFertilizer;
import com.turtywurty.minecraftmadness.objects.items.utility.ItemGoldHeart;
import com.turtywurty.minecraftmadness.objects.items.utility.ItemHeart;
import com.turtywurty.minecraftmadness.objects.items.utility.ItemRing;
import com.turtywurty.minecraftmadness.util.Reference;
import com.turtywurty.minecraftmadness.util.handlers.SoundsHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	private static CreativeTabs tab = MinecraftMadness.MINECRAFTMADNESSTAB;
	
	//Materials
	public static final ToolMaterial TOOL_RUBY = EnumHelper.addToolMaterial("tool_ruby", 4, 1029, 5.0F, 3.5F, 17);
	public static final ToolMaterial TOOL_KNIFE = EnumHelper.addToolMaterial("tool_knife", 2, 250, 7.0F, 5.0F, 14);
	public static final ToolMaterial TOOL_MAGMATIC = EnumHelper.addToolMaterial("tool_magmatic", 3, 5000, 4.0F, 4.0F, 0);
	public static final ArmorMaterial ARMOR_RUBY = EnumHelper.addArmorMaterial("armor_ruby", Reference.MOD_ID + ":ruby", 60, new int[] {4, 7, 9, 5}, 17, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.1F);
	public static final ArmorMaterial ARMOR_REDSTONE = EnumHelper.addArmorMaterial("armor_redstone", Reference.MOD_ID + ":redstone", 30, new int[] {2, 4, 6, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
	public static final ArmorMaterial ARMOR_LAPIS = EnumHelper.addArmorMaterial("armor_lapis", Reference.MOD_ID + ":lapis", 28, new int[] {3, 5, 7, 4}, 400, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial ARMOR_SAPPHIRE = EnumHelper.addArmorMaterial("armor_sapphire", Reference.MOD_ID + ":sapphire", 50, new int[] {4, 6, 8, 4}, 19, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.3F);
	public static final ArmorMaterial ARMOR_MINER = EnumHelper.addArmorMaterial("armor_miner", Reference.MOD_ID + ":miner", 100, new int [] {2, 0, 0, 0}, 50, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.0F);
	public static final ArmorMaterial ARMOR_MAGMATIC = EnumHelper.addArmorMaterial("armor_magmatic", Reference.MOD_ID + ":magmatic", 80, new int[] {8, 11, 16, 9}, 0, SoundsHandler.ITEM_ARMOR_EQUIP_MAGMATIC, 0.0F);
	
	//Orbs
	public static final Item FIRE_RESISTANCE_ORB = new FireResistanceOrb("fire_resistance_orb");
	public static final Item HASTE_ORB = new HasteOrb("haste_orb");
	public static final Item INSTANT_HEALTH_ORB = new InstantHealthOrb("instant_health_orb");
	public static final Item JUMP_BOOST_ORB = new JumpBoostOrb("jump_boost_orb");
	public static final Item LEVITATION_ORB = new LevitationOrb("levitation_orb");
	public static final Item NIGHT_VISION_ORB = new NightVisionOrb("night_vision_orb");
	public static final Item REGENERATION_ORB = new RegenerationOrb("regeneration_orb");
	public static final Item RESISTANCE_ORB = new ResistanceOrb("resistance_orb");
	public static final Item SATURATION_ORB = new SaturationOrb("saturation_orb");
	public static final Item SPEED_ORB = new SpeedOrb("speed_orb");
	public static final Item STRENGTH_ORB = new StrengthOrb("strength_orb");
	public static final Item WATER_BREATHING_ORB = new WaterBreathingOrb("water_breathing_orb");
	
	//Bows
	public static final Item LEATHER_STIFFENED_BOW = new ItemLeatherBow("leather_bow");
	
	//Items
	public static final Item HEART = new ItemHeart("heart");
	public static final Item GOLD_HEART = new ItemGoldHeart("gold_heart");
	public static final Item BACKPACK = new ItemBackpack("backpack").setMaxStackSize(1);
	//public static final Item RING = new ItemRing("ring").setMaxStackSize(1); //TODO Fix Game Crash
	public static final Item FROG_LEGS = new ItemBase("frog_legs");
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item AMETHYST = new ItemBase("amethyst");
	public static final Item SAPPHIRE = new ItemBase("sapphire");
	public static final Item COPPER_INGOT = new ItemBase("copper_ingot");
	public static final Item OBSIDIAN_INGOT = new ItemBase("obsidian_ingot");
	public static final Item TIN_INGOT = new ItemBase("tin_ingot");
	public static final Item SILVER_INGOT = new ItemBase("silver_ingot");
	public static final Item URANIUM_INGOT = new ItemBase("uranium_ingot");
	public static final Item RUBY_CHUNK = new ItemBase("ruby_chunk");
	public static final Item COPPER_NUGGET = new ItemBase("copper_nugget");
	public static final Item OBSIDIAN_NUGGET = new ItemBase("obsidian_nugget");
	public static final Item TIN_NUGGET = new ItemBase("tin_nugget");
	public static final Item SILVER_NUGGET = new ItemBase("silver_nugget");
	public static final Item URANIUM_NUGGET = new ItemBase("uranium_nugget");
	public static final Item COPPER_COIN = new ItemCopperCoin("copper_coin");
	public static final Item SILVER_COIN = new ItemSilverCoin("silver_coin");
	public static final Item GOLD_COIN = new ItemGoldCoin("gold_coin");
	public static final Item TOMATO_SEEDS = new ItemTomatoSeeds("tomato_seeds");
	public static final Item LEMON_SEEDS = new ItemLemonSeeds("lemon_seeds");
	public static final Item SAPPHIRE_CHUNK = new ItemBase("sapphire_chunk");
	public static final Item MOD_BOOK = new ItemModBook("mod_book"); 
	public static final Item URANIUM_DUST = new ItemBase("uranium_dust");
	public static final Item SUPER_MATERIAL = new ItemBase("super_material");
	public static final Item FUR = new ItemBase("fur");
	public static final Item FIRE_ARROW = new ItemFireArrow("fire_arrow");
	public static final Item FERTILIZER = new ItemFertilizer("fertilizer");
	public static final Item ENDER_SHARD = new ItemEnderShard("ender_shard");
	//public static final Item KEY = new ItemKey("key");
	public static final Item MUTATED_SUGARCANE = new ItemMutatedSugarcane("item_mutated_sugarcane");
	public static final Item MUTATED_LILYPAD = new ItemMutatedLilyPad("item_mutated_lilypad");
	public static final Item MAGMATIC_INGOT = new ItemBase("magmatic_ingot");
	public static final Item CUP = new ItemBase("cup");
	public static final Item MADNESS_LOGO = new MadnessLogo("zxdsbkfbjdfbnksbdhsbfbdjfndk");
	
	//Normal Food	
	public static final Item TOMATO = new ItemModFood("tomato", 3, 0.3f, false).setCreativeTab(tab);
	public static final Item LEMON = new ItemModFood("lemon", 2, 0.2f, false).setCreativeTab(tab);
	public static final Item LIME = new ItemModFood("lime", 2, 0.2f, false).setCreativeTab(tab);
	public static final Item KIWI = new ItemModFood("kiwi", 3, 0.2f, false).setCreativeTab(tab);
	public static final Item BANANA = new ItemModFood("banana", 3, 0.2f, false).setCreativeTab(tab);
	public static final Item LETTUCE = new ItemModFood("lettuce", 4, 0.2f, false).setCreativeTab(tab);
	public static final Item ALMONDS = new ItemModFood("almonds", 3, 0.3f, false).setCreativeTab(tab);
	public static final Item ASPARAGUS = new ItemModFood("asparagus", 3, 0.2f, false).setCreativeTab(tab);
	public static final Item AVOCADO = new ItemModFood("avocado", 3, 0.2f, false).setCreativeTab(tab);
	public static final Item BACON = new ItemModFood("bacon", 5, 0.1f, true).setCreativeTab(tab);
	public static final Item COOKED_BACON = new ItemModFood("cooked_bacon", 8, 0.5f, true).setCreativeTab(tab);
	public static final Item BAGEL = new ItemModFood("bagel", 4, 0.2f, false).setCreativeTab(tab);
	public static final Item BIG_MAC = new ItemModFood("big_mac", 10, 0.8f, true).setCreativeTab(tab);
	public static final Item BROCCOLI = new ItemModFood("broccoli", 3, 0.2f, false).setCreativeTab(tab);
	public static final Item BURRITO = new ItemModFood("burrito", 6, 0.4f, true).setCreativeTab(tab);
	public static final Item CELERY = new ItemModFood("celery", 3, 0.1f, false).setCreativeTab(tab);
	public static final Item CHEESE = new ItemModFood("cheese", 3, 0.2f, false).setCreativeTab(tab);
	public static final Item CHOCOLATE = new ItemModFood("chocolate", 3, 0.2f, true).setCreativeTab(tab);
	public static final Item COOKED_BURGER = new ItemModFood("cooked_burger", 8, 0.5f, true).setCreativeTab(tab);
	public static final Item RAW_BURGER = new ItemModFood("raw_burger", 5, 0.1f, true).setCreativeTab(tab);
	public static final Item DOUGHNUT = new ItemModFood("doughnut", 5, 0.3f, false).setCreativeTab(tab);
	public static final Item FRIED_EGG = new ItemModFood("fried_egg", 5, 0.4f, false).setCreativeTab(tab);
	public static final Item FRIES = new ItemModFood("fries", 7, 0.4f, false).setCreativeTab(tab);
	public static final Item GRAPES = new ItemModFood("grapes", 5, 0.2f, false).setCreativeTab(tab);
	public static final Item GREEN_BEANS = new ItemModFood("green_beans", 3, 0.2f, false).setCreativeTab(tab);
	public static final Item HASH_BROWN = new ItemModFood("hash_brown", 5, 0.4f, false).setCreativeTab(tab);
	public static final Item HOT_DOG = new ItemModFood("hot_dog", 9, 0.6f, true).setCreativeTab(tab);
	public static final Item ICE_CREAM = new ItemModFood("ice_cream", 7, 0.5f, false).setCreativeTab(tab);
	public static final Item KETCHUP = new ItemModFood("ketchup", 11, 0.1f, false).setCreativeTab(tab); //TODO Nausea Effect
	public static final Item PRUNES = new ItemModFood("prunes", 3, 0.1f, false).setCreativeTab(tab);
	public static final Item RAW_SAUSAGE = new ItemModFood("raw_sausage", 5, 0.1f, true).setCreativeTab(tab);
	public static final Item SAUSAGE = new ItemModFood("sausage", 10, 0.5f, true).setCreativeTab(tab);
	public static final Item TOAST = new ItemModFood("toast", 7, 0.2f, false).setCreativeTab(tab);
	public static final Item SUSHI = new ItemModFood("sushi", 8, 0.4f, false).setCreativeTab(tab);
	public static final Item RAW_VENISON = new ItemModFood("raw_venison", 5, 0.1f, true).setCreativeTab(tab);
	public static final Item COOKED_VENISON = new ItemModFood("cooked_venison", 14, 0.5f, true).setCreativeTab(tab);
	public static final Item PEACH = new ItemModFood("peach", 2, 0.2f, false).setCreativeTab(tab);
	public static final Item WALNUT = new ItemModFood("walnut", 1, 0.3f, false).setCreativeTab(tab);
	public static final Item CORN = new ItemModFood("corn", 4, 0.4f, false).setCreativeTab(tab);
	public static final Item SANDWICH = new ItemModFood("sandwich", 8, 0.6f, true).setCreativeTab(tab);
	public static final Item DOG_BISCUIT = new ItemModFood("dog_biscuit", 3, 1.0f, true).setCreativeTab(tab);
	public static final Item ORANGE = new ItemModFood("orange", 3, 0.f, false).setCreativeTab(tab);
	public static final Item OLIVE = new ItemModFood("olive", 1, 0.4f, false).setCreativeTab(tab);
	public static final Item NORI = new ItemModFood("nori", 1, 0.7f, false).setCreativeTab(tab);
	public static final Item SALT = new ItemSalt("salt", 1, 0.2f, false, new PotionEffect(MobEffects.WEAKNESS)).setCreativeTab(tab);
	public static final Item RICE = new ItemRice("rice", 2, 0.6f, false).setCreativeTab(tab);
	public static final Item CINAMON = new ItemModFood("cinamon", 2, 0.2f, false).setCreativeTab(tab);
	
	//Untextured Food/Ingredients 
	/*public static final Item PLUM = new ItemModFood("plum", 2, 0.4f, false).setCreativeTab(tab);
	public static final Item APPLE_PIE = new ItemApplePie("apple_pie", 8, 0.4f, false).setCreativeTab(tab);
	public static final Item MAYONNAISE = new ItemModFood("mayonnaise", 2, 0.4f, false).setCreativeTab(tab);
	public static final Item MUSTARD = new ItemModFood("mustard", 2, 0.6f, false).setCreativeTab(tab);
	public static final Item OLIVE_OIL = new ItemOliveOil("olive_oil", 2, 0.1f, false, new PotionEffect(MobEffects.INSTANT_DAMAGE, 5, 1), new PotionEffect(MobEffects.NAUSEA, 500, 20)).setCreativeTab(tab);
	public static final Item PEPPERONI = new ItemModFood("pepperoni", 4, 0.5f, true).setCreativeTab(tab);
	public static final Item MINT = new ItemMint("mint", 1, 0.2f, false).setCreativeTab(tab);
	public static final Item PEPPER = new ItemModFood("pepper", 3, 0.2f, false).setCreativeTab(tab);
	public static final Item RADDISH = new ItemModFood("raddish", 2, 0.1f, false).setCreativeTab(tab);
	public static final Item CUCUMBER = new ItemModFood("cucumber", 3, 0.5f, false).setCreativeTab(tab);
	public static final Item TEA = new ItemBase("tea");
	public static final Item TEA_BAG = new ItemBase("tea_bag");
	public static final Item TEA_DRINK = new ItemModDrink("tea_drink", 3, 0.3f, false).setCreativeTab(tab).setMaxStackSize(1);
	public static final Item COFFEE_BEANS = new ItemCoffeeBeans("coffee_beans");
	public static final Item HOT_CHOCOLATE = new ItemModDrink("hot_chocolate", 2, 0.7f, false).setCreativeTab(tab).setMaxStackSize(1);
	public static final Item WHITE_CHOCOLATE = new ItemModFood("white_chocolate", 3, 0.5f, false).setCreativeTab(tab);
	public static final Item DARK_CHOCOLATE = new ItemModFood("dark_chocolate", 3, 0.7f, false).setCreativeTab(tab);
	public static final Item GINGER = new ItemGinger("ginger", 1, 0.1f, false, new PotionEffect(MobEffects.NAUSEA, 50, 3)).setCreativeTab(tab);
	public static final Item BUTTER = new ItemButter("butter", 2, 0.8f, false, new PotionEffect(MobEffects.NAUSEA, 5, 50));
	public static final Item MARGARINE = new ItemMargarine("margarine", 2, 0.7f, false, new PotionEffect(MobEffects.NAUSEA, 5, 50)).setCreativeTab(tab);
	public static final Item NOODLES = new ItemModFood("noodles", 5, 0.4f, false).setCreativeTab(tab);
	public static final Item PASTA = new ItemModFood("pasta", 5, 0.4f, false).setCreativeTab(tab);
	public static final Item CURRY = new ItemModFood("curry", 6, 0.5, false).setCreativeTab(tab);
	public static final Item COCONUT = new ItemCoconut("coconut", 3, 0.4f, false).setCreativeTab(tab);*/
	
	//Special Food
	public static final Item GREEN_APPLE = new ItemGreenApple("green_apple", 2, 0.4F, false);
	public static final Item SKINNED_FROG_LEGS = new ItemSkinnedFrogLegs(2, 3.0F, true, "skinned_frog_legs");
	public static final Item COOKED_FROG_LEGS = new ItemCookedFrogLegs(9, 5.0F, true, "cooked_frog_legs");
	public static final Item RUBY_APPLE = new ItemRubyApple(4, 9.6F, false, "ruby_apple");
	public static final Item ENCHANTED_RUBY_APPLE = new ItemEnchantedRubyApple(4, 9.6F, false, "enchanted_ruby_apple");
	public static final Item DORITO = new ItemDorito("dorito", 1, 0.1f, false);
	
	//Drinks
	public static final Item MILKSHAKE = new ItemModDrink("milkshake", 5, 0.3f, false).setCreativeTab(tab).setMaxStackSize(1);
	public static final Item BEER = new ItemModDrink("beer", 2, 0.3f, false).setCreativeTab(tab).setMaxStackSize(1);
	public static final Item COFFEE = new ItemModDrink("coffee", 4, 0.3f, false).setCreativeTab(tab).setMaxStackSize(1);
	public static final Item HONEY = new ItemModDrink("honey", 3, 0.3f, false).setCreativeTab(tab).setMaxStackSize(1);
	public static final Item TOMATO_SOUP = new ItemTomatoSoup("tomato_soup", 9, false).setMaxStackSize(1);
	
	//Smoothies
	public static final Item KIWI_BANANA_S = new ItemModDrink("kiwi_banana_s", 8, 0.6f, false).setCreativeTab(tab).setMaxStackSize(1);
	public static final Item KIWI_ORANGE_S = new ItemModDrink("kiwi_orange_s", 8, 0.5f, false).setCreativeTab(tab).setMaxStackSize(1);
	public static final Item KIWI_GAPPLE_S = new ItemModDrink("kiwi_gapple_s", 8, 0.7f, false).setCreativeTab(tab).setMaxStackSize(1);
	public static final Item KIWI_APPLE_S = new ItemModDrink("kiwi_apple_s", 8, 0.6f, false).setCreativeTab(tab).setMaxStackSize(1);
	
	/*Spawn Eggs
	*public static final Item FROG_SPAWN_EGG = new FrogSpawnEgg("frog_spawn_egg");
	*/
	
	//Tools
	public static final Item SWORD_RUBY = new ToolSword("sword_ruby", TOOL_RUBY);
	public static final Item PICKAXE_RUBY = new ToolPickaxe("pickaxe_ruby", TOOL_RUBY);
	public static final Item SHOVEL_RUBY = new ToolShovel("shovel_ruby", TOOL_RUBY);
	public static final Item AXE_RUBY = new ToolAxe("axe_ruby", TOOL_RUBY);
	public static final Item HOE_RUBY = new ToolHoe("hoe_ruby", TOOL_RUBY);
	
	public static final Item SWORD_MAGMATIC = new MagmaticSword("sword_magmatic", TOOL_MAGMATIC);
	public static final Item PICKAXE_MAGMATIC = new MagmaticPickaxe("pickaxe_magmatic", TOOL_MAGMATIC);
	public static final Item SHOVEL_MAGMATIC = new MagmaticShovel("shovel_magmatic", TOOL_MAGMATIC);
	public static final Item AXE_MAGMATIC = new MagmaticAxe("axe_magmatic", TOOL_MAGMATIC);
	public static final Item HOE_MAGMATIC = new MagmaticHoe("hoe_magmatic", TOOL_MAGMATIC);
	
	public static final Item KNIFE = new ItemKnife("knife", TOOL_KNIFE);
	public static final Item PIZZA_CUTTER = new ItemPizzaCutter("pizza_cutter");
			
	//Armor
	public static final Item HELMET_RUBY = new ArmorBase("helmet_ruby", ARMOR_RUBY, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_RUBY = new ArmorBase("chestplate_ruby", ARMOR_RUBY, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_RUBY = new ArmorBase("leggings_ruby", ARMOR_RUBY, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_RUBY = new ArmorBase("boots_ruby", ARMOR_RUBY, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_REDSTONE = new ArmorBase("helmet_redstone", ARMOR_REDSTONE, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_REDSTONE = new ArmorBase("chestplate_redstone", ARMOR_REDSTONE, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_REDSTONE = new ArmorBase("leggings_redstone", ARMOR_REDSTONE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_REDSTONE = new ArmorBase("boots_redstone", ARMOR_REDSTONE, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_LAPIS = new ArmorBase("helmet_lapis", ARMOR_LAPIS, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_LAPIS = new ArmorBase("chestplate_lapis", ARMOR_LAPIS, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_LAPIS = new ArmorBase("leggings_lapis", ARMOR_LAPIS, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_LAPIS = new ArmorBase("boots_lapis", ARMOR_LAPIS, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_SAPPHIRE = new ArmorBase("helmet_sapphire", ARMOR_SAPPHIRE, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_SAPPHIRE = new ArmorBase("chestplate_sapphire", ARMOR_SAPPHIRE, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_SAPPHIRE = new ArmorBase("leggings_sapphire", ARMOR_SAPPHIRE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_SAPPHIRE = new ArmorBase("boots_sapphire", ARMOR_SAPPHIRE, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_MAGMATIC = new MagmaticArmor("helmet_magmatic", ARMOR_MAGMATIC, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_MAGMATIC = new MagmaticArmor("chestplate_magmatic", ARMOR_MAGMATIC, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_MAGMATIC = new MagmaticArmor("leggings_magmatic", ARMOR_MAGMATIC, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_MAGMATIC = new MagmaticArmor("boots_magmatic", ARMOR_MAGMATIC, 1, EntityEquipmentSlot.FEET);
	
	//public static final Item HELMET_MINER = new ArmorMiner("helmet_miner", ARMOR_MINER, 1, EntityEquipmentSlot.HEAD);
}