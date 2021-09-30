package me.sirhenry.parkourextras;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.meta.BlockDataMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class BlockHash {

    private static ArrayList<Location> BlockData = new ArrayList<Location>();

    public static ArrayList<Location> get() {
        return BlockData;
    }

}
