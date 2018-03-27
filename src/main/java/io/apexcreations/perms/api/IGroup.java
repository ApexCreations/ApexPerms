package io.apexcreations.perms.api;

import org.bukkit.permissions.Permission;

import java.util.List;

public interface IGroup {

    String getName();
    List<String> getPermissions();
    List<IGroup> getInheritedGroups();
    void setPermission(String permission);
    void setPermission(Permission permission);
}