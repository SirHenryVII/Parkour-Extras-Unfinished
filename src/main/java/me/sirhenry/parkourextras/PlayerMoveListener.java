package me.sirhenry.parkourextras;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void PlayerMove(PlayerMoveEvent e) {

        Player player = e.getPlayer();
        Location loc = player.getLocation();
        loc.setY(loc.getY()-1);
        loc.setX(loc.getX()-1);
        String x = "" + loc.getX();
        String z = "" + loc.getZ();
        if(x.contains(".")) x = x.substring(0, x.indexOf("."));
        if(z.contains(".")) z = z.substring(0, z.indexOf("."));
        loc.setX(Double.parseDouble(x));
        loc.setZ(Double.parseDouble(z));
        loc.setPitch(0);
        loc.setYaw(0);

        if(BlockHash.get().contains(loc)) {

            if (loc.getBlock().getType() == Material.BLUE_CONCRETE) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 10));
            }
            else if (loc.getBlock().getType() == Material.GREEN_CONCRETE) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20, 10));
            }
            else if (loc.getBlock().getType() == Material.BLACK_CONCRETE) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 3));
            }

        }

    }

}
