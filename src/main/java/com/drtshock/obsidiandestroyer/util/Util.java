package com.drtshock.obsidiandestroyer.util;

import com.drtshock.obsidiandestroyer.managers.ConfigManager;
import com.drtshock.obsidiandestroyer.managers.HookManager;
import com.drtshock.obsidiandestroyer.managers.MaterialManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.util.BlockIterator;

import java.util.Random;

public class Util {

    public static boolean isSolid(Material material) {
        switch (material) {
            case AIR:
            case ARROW:
            case APPLE:
            case BAKED_POTATO:
            case BED:
            case BLAZE_ROD:
            case BLAZE_POWDER:
            case BOAT:
            case BONE:
            case BOOK:
            case BOW:
            case BOWL:
            case BREAD:
            case BUCKET:
            case CAKE:
            case CARROT:
            case CARROT_ITEM:
            case CAULDRON_ITEM:
            case CHAINMAIL_BOOTS:
            case CHAINMAIL_CHESTPLATE:
            case CHAINMAIL_HELMET:
            case CHAINMAIL_LEGGINGS:
            case CLAY_BALL:
            case CLAY_BRICK:
            case COAL:
            case COCOA:
            case COMPASS:
            case COOKED_BEEF:
            case COOKED_CHICKEN:
            case COOKED_FISH:
            case COOKIE:
            case DIAMOND:
            case DIAMOND_AXE:
            case DIAMOND_BARDING:
            case DIAMOND_BOOTS:
            case DIAMOND_CHESTPLATE:
            case DIAMOND_HELMET:
            case DIAMOND_HOE:
            case DIAMOND_LEGGINGS:
            case DIAMOND_PICKAXE:
            case DIAMOND_SPADE:
            case DIAMOND_SWORD:
            case EGG:
            case EMERALD:
            case EMPTY_MAP:
            case ENCHANTED_BOOK:
            case ENDER_PEARL:
            case EXP_BOTTLE:
            case EYE_OF_ENDER:
            case FEATHER:
            case FERMENTED_SPIDER_EYE:
            case FIREBALL:
            case FIREWORK:
            case FIREWORK_CHARGE:
            case FLINT:
            case FLINT_AND_STEEL:
            case GHAST_TEAR:
            case GLASS_BOTTLE:
            case GLOWSTONE_DUST:
            case GOLDEN_APPLE:
            case GOLDEN_CARROT:
            case GOLD_AXE:
            case GOLD_BARDING:
            case GOLD_BOOTS:
            case GOLD_CHESTPLATE:
            case GOLD_HELMET:
            case GOLD_HOE:
            case GOLD_INGOT:
            case GOLD_LEGGINGS:
            case GOLD_NUGGET:
            case GOLD_PICKAXE:
            case GOLD_PLATE:
            case GOLD_RECORD:
            case GOLD_SPADE:
            case GOLD_SWORD:
            case GREEN_RECORD:
            case GRILLED_PORK:
            case HOPPER_MINECART:
            case INK_SACK:
            case IRON_AXE:
            case IRON_BARDING:
            case IRON_BOOTS:
            case IRON_CHESTPLATE:
            case IRON_HELMET:
            case IRON_HOE:
            case IRON_INGOT:
            case IRON_LEGGINGS:
            case IRON_PICKAXE:
            case IRON_PLATE:
            case IRON_SPADE:
            case IRON_SWORD:
            case LAVA_BUCKET:
            case LEASH:
            case LEATHER:
            case LEATHER_BOOTS:
            case LEATHER_CHESTPLATE:
            case LEATHER_HELMET:
            case LEATHER_LEGGINGS:
            case MAGMA_CREAM:
            case MAP:
            case MELON:
            case MELON_SEEDS:
            case MILK_BUCKET:
            case MINECART:
            case MONSTER_EGG:
            case MONSTER_EGGS:
            case MUSHROOM_SOUP:
            case NAME_TAG:
            case NETHER_WARTS:
            case NETHER_BRICK_ITEM:
            case NETHER_STAR:
            case PAINTING:
            case PAPER:
            case POISONOUS_POTATO:
            case PORK:
            case POTATO:
            case POTATO_ITEM:
            case POTION:
            case POWERED_MINECART:
            case PUMPKIN_SEEDS:
            case PUMPKIN_PIE:
            case QUARTZ:
            case RAW_BEEF:
            case RAW_CHICKEN:
            case RAW_FISH:
            case RECORD_10:
            case RECORD_11:
            case RECORD_12:
            case RECORD_3:
            case RECORD_4:
            case RECORD_5:
            case RECORD_6:
            case RECORD_7:
            case RECORD_8:
            case RECORD_9:
            case REDSTONE:
            case ROTTEN_FLESH:
            case SADDLE:
            case SEEDS:
            case SHEARS:
            case SKULL_ITEM:
            case SLIME_BALL:
            case SNOW:
            case SNOW_BALL:
            case SPECKLED_MELON:
            case SPIDER_EYE:
            case STICK:
            case STONE_AXE:
            case STONE_HOE:
            case STONE_PICKAXE:
            case STONE_PLATE:
            case STONE_SPADE:
            case STONE_SWORD:
            case STORAGE_MINECART:
            case STRING:
            case SUGAR:
            case SUGAR_CANE:
            case SULPHUR:
            case WATCH:
            case WATER_BUCKET:
            case WHEAT:
            case WOOD_HOE:
            case WOOD_PICKAXE:
            case WOOD_PLATE:
            case WOOD_SPADE:
            case WOOD_SWORD:
            case WRITTEN_BOOK:
                return false;
            default:
                break;
        }
        return true;
    }

    public static int getMaxDistance(String material, int defaultRadius) {
        int dist = MaterialManager.getInstance().getBlastRadius(material);
        if (dist <= 0) {
            dist = defaultRadius;
        }
        return dist;
    }

    @Deprecated
    public static boolean checkIfMax(int value, String id) {
        return value >= MaterialManager.getInstance().getDurability(id);
    }

    public static boolean checkIfMax(int value, String id, double multi) {
        return value >= Math.round(MaterialManager.getInstance().getDurability(id) * multi);
    }

    public static boolean checkIfOverMax(int value, String id, double multi) {
        final int du = MaterialManager.getInstance().getDurability(id);
        return value > Math.round((du * multi) + (du * 0.18));
    }

    public static boolean isNearLiquid(Location location) {
        for (BlockFace face : BlockFace.values()) {
            switch (face) {
                case NORTH:
                case EAST:
                case SOUTH:
                case WEST:
                case UP:
                case DOWN:
                case SELF:
                    if (location.getBlock().getRelative(face) != null && location.getBlock().getRelative(face).isLiquid()) {
                        return true;
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }

    public static boolean isTargetsPathBlocked(Location tLoc, Location dLoc) {
        // Create a vector trace from the detonator location to damaged block's location
        BlockIterator blocksInPath = new BlockIterator(tLoc.getWorld(), dLoc.toVector(), tLoc.toVector().subtract(dLoc.toVector()).normalize(), 0, (int) dLoc.distance(tLoc));

        if (blocksInPath == null) {
            return false;
        }

        // iterate through the blocks in the path
        while (blocksInPath.hasNext()) {
            // the next block
            final Block block = blocksInPath.next();
            if (block == null) {
                continue;
            }

            // check if next block is the target block
            if (tLoc.getWorld().getName().equals(block.getWorld().getName()) &&
                    tLoc.getBlockX() == block.getX() &&
                    tLoc.getBlockY() == block.getY() &&
                    tLoc.getBlockZ() == block.getZ()) {
                // ignore target block
                continue;
            }

            // check if the block is a solid
            if (!isNonSolid(block.getType())) {
                return true;
            }
        }
        return false;
    }

    public static double getMultiplier(Location location) {
        if (!HookManager.getInstance().isFactionsFound()) {
            return 1D;
        }

        double value = 1D;
        if (!ConfigManager.getInstance().getHandleFactions()) {
            return value;
        }
        if (HookManager.getInstance().getFactionsManager().getFactions().isExplosionsEnabled(location)) {
            value = 1D;
        }
        if (ConfigManager.getInstance().getHandleOfflineFactions()) {
            if (HookManager.getInstance().getFactionsManager().getFactions().isFactionOffline(location)) {
                value = ConfigManager.getInstance().getOfflineFactionsDurabilityMultiplier();
            }
        }
        if (ConfigManager.getInstance().getHandleOnlineFactions()) {
            if (!HookManager.getInstance().getFactionsManager().getFactions().isFactionOffline(location)) {
                value = ConfigManager.getInstance().getOnlineFactionsDurabilityMultiplier();
            }
        }
        if (value <= 0) {
            value = 1D;
        }

        return value;
    }

    public static String header() {
        return ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "ObsidianDestroyer" + ChatColor.DARK_AQUA + "] " + ChatColor.RESET;
    }

    public static int getRandomNumberFrom(int min, int max) {
        Random foo = new Random();
        int randomNumber = foo.nextInt((max + 1) - min) + min;

        return randomNumber;
    }

    public static boolean isNonSolid(Material type) {
        switch (type) {
            case AIR:
            case LONG_GRASS:
            case DEAD_BUSH:
            case THIN_GLASS:
            case YELLOW_FLOWER:
            case RED_ROSE:
            case BROWN_MUSHROOM:
            case RED_MUSHROOM:
            case SNOW:
            case WEB:
            case STRING:
            case VINE:
            case DOUBLE_PLANT:
            case FIRE:
            case TORCH:
            case REDSTONE_TORCH_ON:
            case REDSTONE_TORCH_OFF:
            case REDSTONE:
                return true;
            default:
                return false;
        }
    }
}
