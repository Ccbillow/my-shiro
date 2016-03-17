package org.cbillow.shiro.service;

import org.cbillow.shiro.dao.RoleDao;
import org.cbillow.shiro.dao.RoleDaoImpl;
import org.cbillow.shiro.model.Role;

/**
 * @author Created by Cbillow
 * @date 16/3/13
 * @time 22:11
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = new RoleDaoImpl();

    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    public void correlatiomPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
}
