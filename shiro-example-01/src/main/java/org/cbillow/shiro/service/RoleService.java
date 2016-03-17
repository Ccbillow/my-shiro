package org.cbillow.shiro.service;

import org.cbillow.shiro.model.Role;

/**
 * @author Created by Cbillow
 * @date 16/3/13
 * @time 22:10
 */
public interface RoleService {

    public Role createRole(Role role);
    public void deleteRole(Long roleId);

    public void correlatiomPermissions(Long roleId, Long... permissionIds);
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
