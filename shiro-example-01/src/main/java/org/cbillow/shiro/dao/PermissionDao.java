package org.cbillow.shiro.dao;

import org.cbillow.shiro.model.Permission;

/**
 * @author Created by Cbillow
 * @date 16/3/12
 * @time 22:46
 */
public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
