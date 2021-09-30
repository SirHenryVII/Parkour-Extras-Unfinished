package me.sirhenry.parkourextras;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockCommands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if(args[0].equalsIgnoreCase("Speed")) {

                ItemStack Block = new ItemStack(Material.BLUE_CONCRETE);
                ItemMeta meta = Block.getItemMeta();
                meta.setDisplayName(ChatColor.BLUE + "Speed Block");
                Block.setItemMeta(meta);
                ((Player) sender).getInventory().addItem(Block);

            }
            else if(args[0].equalsIgnoreCase("Jump")) {

                ItemStack Block = new ItemStack(Material.GREEN_CONCRETE);
                ItemMeta meta = Block.getItemMeta();
                meta.setDisplayName(ChatColor.GREEN + "Jump Block");
                Block.setItemMeta(meta);
                ((Player) sender).getInventory().addItem(Block);

                }
            else if(args[0].equalsIgnoreCase("Blind")) {

                ItemStack Block = new ItemStack(Material.BLACK_CONCRETE);
                ItemMeta meta = Block.getItemMeta();
                meta.setDisplayName(ChatColor.DARK_BLUE + "Blindness Block");
                Block.setItemMeta(meta);
                ((Player) sender).getInventory().addItem(Block);

            }
            else {

                sender.sendMessage(ChatColor.RED + "Please Give One Of the Following:");
                sender.sendMessage(ChatColor.RED + "speedblock");
                sender.sendMessage(ChatColor.RED + "jumpblock");
                sender.sendMessage(ChatColor.RED + "blindblock");

            }


            }
        return false;
    }

}
