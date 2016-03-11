package org.cbillow.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @author Created by Cbillow
 * @date 16/3/11
 * @time 19:29
 */
public class MyPermissionResolver implements PermissionResolver {

    @Override
    public Permission resolvePermission(String s) {
        if (s.startsWith("+")) {
            return new MyPermission(s);
        }
        return new WildcardPermission(s);
    }
}
