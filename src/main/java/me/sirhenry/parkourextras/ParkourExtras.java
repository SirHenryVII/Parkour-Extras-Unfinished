package me.sirhenry.parkourextras;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class ParkourExtras extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        BlockData.setup();
        BlockData.getData().options().copyDefaults(true);
        BlockData.saveData();
        getCommand("GiveBlock").setExecutor(new BlockCommands());
        getServer().getPluginManager().registerEvents(new PlayerPlaceBlockListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBrokenListener(), this);
        BlockData.getData().addDefault("Blocks", null);
        BlockData.getData().addDefault("Parkour", null);

        for(String key : BlockData.getData().getConfigurationSection("Blocks").getKeys(false)) {

            double x = BlockData.getData().getDouble("Blocks." + key + ".LocationX");
            double y = BlockData.getData().getDouble("Blocks." + key + ".LocationY");
            double z = BlockData.getData().getDouble("Blocks." + key + ".LocationZ");
            String world = BlockData.getData().getString("Blocks." + key + ".world");
            World w = Bukkit.getServer().getWorld(world);
            Location loc = new Location(w, x, y, z);
            BlockHash.get().add(loc);

        }

    }

    @Override
    public void onDisable() {

    }
}
