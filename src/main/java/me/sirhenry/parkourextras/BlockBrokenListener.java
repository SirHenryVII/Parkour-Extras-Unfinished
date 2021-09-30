package me.sirhenry.parkourextras;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBrokenListener implements Listener {

    @EventHandler
    public void BlockBroken(BlockBreakEvent e) {

        Block block = e.getBlock();
        if(BlockHash.get().contains(block.getLocation())) {

            BlockHash.get().remove(block.getLocation());

            for(String key : BlockData.getData().getConfigurationSection("Blocks").getKeys(false)) {

                if(BlockData.getData().getDouble("Blocks." + key + ".LocationX") == block.getLocation().getX() && BlockData.getData().getDouble("Blocks." + key + ".LocationY") == block.getLocation().getY() && BlockData.getData().getDouble("Blocks." + key + ".LocationZ") == block.getLocation().getZ() && BlockData.getData().getString("Blocks." + key + ".world").equalsIgnoreCase(block.getWorld().getName())) {

                    BlockData.getData().set("Blocks." + key, null);

                    BlockData.saveData();
                    break;

                }

            }

        }

        }

    }

