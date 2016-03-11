package org.cbillow.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.cbillow.shiro.permission.MyPermission;

/**
 * @author Created by Cbillow
 * @date 16/3/10
 * @time 23:30
 */
public class StaticRealm extends AuthorizingRealm {

    /**
     * 用来判断授权的
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("r1");
        info.addRole("r2");
        info.addStringPermission("+user+*");
        info.addObjectPermission(new MyPermission("+topic+create"));
        info.addObjectPermission(new MyPermission("+topic+delete+1"));
        info.addObjectPermission(new WildcardPermission("test:*"));
        return info;
    }

    /**
     * 用来判断认证的
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());
        if (!"kh".equals(username)) throw new UnknownAccountException("用户不存在");
        if (!"123".equals(password)) throw new IncorrectCredentialsException("密码错误");
        return new SimpleAuthenticationInfo("ctaoaoo@iCloud.com", password, getName());
    }
}
