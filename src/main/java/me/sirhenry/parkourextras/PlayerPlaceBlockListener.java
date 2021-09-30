package me.sirhenry.parkourextras;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerPlaceBlockListener implements Listener {

    @EventHandler
    public void blockPlacedListener(BlockPlaceEvent e) {

        Block block = e.getBlock();
        ItemMeta handItemMeta = e.getItemInHand().getItemMeta();
        String name = handItemMeta.getDisplayName();

        if(name.equalsIgnoreCase("§9Speed Block") || name.equalsIgnoreCase("§aJump Block") || name.equalsIgnoreCase("§0Blind Block"))
            BlockHash.get().add(block.getLocation());
            Double x = block.getLocation().getX();
            Double y = block.getLocation().getY();
            Double z = block.getLocation().getZ();
            String world = block.getWorld().getName();
            String blockUID = block.getLocation().toString().replace(".", ",");


            BlockData.getData().set("Blocks." + blockUID + "." + "world", world);
            BlockData.getData().set("Blocks." + blockUID + "." + "LocationX", x);
            BlockData.getData().set("Blocks." + blockUID + "." + "LocationY", y);
            BlockData.getData().set("Blocks." + blockUID + "." + "LocationZ", z);

            BlockData.saveData();


    }

}
