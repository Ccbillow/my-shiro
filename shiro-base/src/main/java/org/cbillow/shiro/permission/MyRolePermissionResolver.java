package org.cbillow.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Created by Cbillow
 * @date 16/3/11
 * @time 20:10
 */
public class MyRolePermissionResolver implements RolePermissionResolver {
    @Override
    public Collection<Permission> resolvePermissionsInRole(String s) {
        if (s.contains("r1")) {
            return Arrays.asList((Permission) new WildcardPermission("classroom:*"));
        }
        return null;
    }
}
