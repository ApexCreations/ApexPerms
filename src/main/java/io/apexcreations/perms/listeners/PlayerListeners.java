package io.apexcreations.perms.listeners;

import io.apexcreations.perms.api.IUser;
import io.apexcreations.perms.impl.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        IUser user = new User(player.getUniqueId());
    }
}