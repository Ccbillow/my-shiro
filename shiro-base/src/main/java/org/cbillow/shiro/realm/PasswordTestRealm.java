package org.cbillow.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author Created by Cbillow
 * @date 16/3/11
 * @time 21:05
 */
public class PasswordTestRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String u = "user";
        String p = "6ad14ba9986e3615423dfca256d04e3f";
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("ctaoaoo@iCloud.com", p, getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(u));
        return info;
    }
}
