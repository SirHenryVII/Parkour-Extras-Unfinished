package me.sirhenry.parkourextras;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BlockData {

    private static File file;
    private static FileConfiguration Data;

    public static void setup() {

        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ParkourExtras").getDataFolder(), "Data.yml");

        if(!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Could Not Make Block Data File");
            }

        }
        Data = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getData() {
        return Data;
    }

    public static void saveData(){
        try {
            Data.save(file);
        } catch (IOException e) {
            System.out.println("Couldn't Save Block Data");
        }
    }

    public static void reloadData() {

        Data = YamlConfiguration.loadConfiguration(file);

    }

}
