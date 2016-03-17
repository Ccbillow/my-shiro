package org.cbillow.shiro.dao;

import org.cbillow.shiro.model.Role;

/**
 * @author Created by Cbillow
 * @date 16/3/12
 * @time 22:46
 */
public interface RoleDao {

    public Role createRole(Role role);

    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId, Long... permissionIds);

    public void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
