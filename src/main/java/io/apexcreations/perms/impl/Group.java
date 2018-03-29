package io.apexcreations.perms.impl;

import com.google.common.collect.Sets;
import io.apexcreations.perms.api.IGroup;
import org.bukkit.permissions.Permission;

import java.util.List;
import java.util.Set;

public class Group implements IGroup {

    private String name;
    private List<String> permissionList;
    private List<IGroup> inheritFrom;
    
    private Set<IGroup> groups;

    public Group(String name, List<String> permissionList, List<IGroup> inheritFrom) {
        this.name = name;
        this.permissionList = permissionList;
        this.inheritFrom = inheritFrom;
        
        groups = Sets.newConcurrentHashSet();
        groups.add(this);
    }

    public void setPermission(Permission permission) {
        this.permissionList.add(permission.getName());
    }

    public void setPermission(String permission) {
        this.permissionList.add(permission);
    }

    @Override
    public List<String> getPermissions() {
        return permissionList;
    }

    @Override
    public List<IGroup> getInheritedGroups() {
        return inheritFrom;
    }

    @Override
    public String getName() {
        return name;
    }
}