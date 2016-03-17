package org.cbillow.shiro.service;

import org.cbillow.shiro.model.Permission;

/**
 * @author Created by Cbillow
 * @date 16/3/13
 * @time 22:13
 */
public interface PermissionService {

    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
