package io.apexcreations.perms.impl;

import com.google.common.collect.Lists;
import io.apexcreations.perms.ApexPerms;
import io.apexcreations.perms.api.IGroup;
import io.apexcreations.perms.api.IUser;
import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.util.List;
import java.util.UUID;

@Data
public class User implements IUser {

    private UUID uniqueId;
    private IGroup rank;
    private PermissionAttachment permissionAttachment;
    
    private List<IUser> users;

    public User(UUID uniqueId) {
        this.uniqueId = uniqueId;
        this.permissionAttachment = Bukkit.getPlayer(uniqueId).addAttachment(ApexPerms.getInstance());
        this.rank = ApexPerms.getInstance().getRanks().get(0);

        updatePermissions();
        users = Lists.newArrayList();
        users.add(this);
    }

    public void updatePermissions() {
        for (PermissionAttachmentInfo permissionInfo: getPlayer().getEffectivePermissions()) {
            this.permissionAttachment.unsetPermission(permissionInfo.getPermission());
            this.permissionAttachment.setPermission(permissionInfo.getPermission(), false);
        }

        for (String perm: rank.getPermissions()) {
            this.permissionAttachment.setPermission(perm, true);
        }
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uniqueId);
    }
}