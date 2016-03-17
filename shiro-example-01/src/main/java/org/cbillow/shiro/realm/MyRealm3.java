package org.cbillow.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.cbillow.shiro.model.User;

/**
 * @author Created by Cbillow
 * @date 16/3/13
 * @time 23:00
 */
public class MyRealm3 implements Realm {
    public String getName() {
        return "c";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = new User("zhang", "123");
        return new SimpleAuthenticationInfo(
                user,
                "123",
                getName()
        );
    }
}
