package io.apexcreations.perms;

import io.apexcreations.perms.api.IGroup;
import io.apexcreations.perms.api.IUser;
import lombok.Getter;
import io.apexcreations.perms.listeners.PlayerListeners;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class ApexPerms extends JavaPlugin {
    @Getter
    private HashMap<Integer, IGroup> ranks = new HashMap<>();
    @Getter
    private HashMap<UUID, IUser> permissible = new HashMap<>();

    @Override
    public void onEnable() {
        register(new PlayerListeners());
    }
    
    // Why did you need this as static?
    private void register(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    @Override
    public void onDisable() {
    }

}