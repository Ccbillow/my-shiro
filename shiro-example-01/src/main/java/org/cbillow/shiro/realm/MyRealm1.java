package org.cbillow.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author Created by Cbillow
 * @date 16/3/13
 * @time 22:58
 */
public class MyRealm1 implements Realm {
    public String getName() {
        return "a";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return new SimpleAuthenticationInfo(
                "zhangsan",
                "123",
                getName()
        );
    }
}
