package org.cbillow.shiro.service;

import org.cbillow.shiro.dao.PermissionDao;
import org.cbillow.shiro.dao.PermissionDaoImpl;
import org.cbillow.shiro.model.Permission;

/**
 * @author Created by Cbillow
 * @date 16/3/13
 * @time 22:13
 */
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
