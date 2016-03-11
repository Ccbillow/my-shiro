package org.cbillow.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by Cbillow
 * @date 16/3/10
 * @time 14:16
 */
public class MapRealm implements Realm {

    private static Map<String, String> users;
    static {
        users = new HashMap<String, String>();
        users.put("kh", "123");
        users.put("laozhang", "123");
    }

    @Override
    public String getName() {
        return "mapRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());
        if (!users.containsKey(username)) throw new UnknownAccountException("用户名有错");
        if (!password.equals(users.get(username))) throw new IncorrectCredentialsException("密码出错");
        AuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }
}
