package org.cbillow.shiro.realm;

import junit.framework.Assert;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.cbillow.shiro.BaseTest;
import org.junit.Test;

/**
 * @author Created by Cbillow
 * @date 16/3/13
 * @time 23:25
 */
public class UserRealmTest extends BaseTest {

    @Test
    public void testLoingSuccess() {
        login("classpath:shiro.ini", u1.getUsername(), password);
        Assert.assertTrue(subject().isAuthenticated());
    }

    @Test(expected = UnknownAccountException.class)
    public void testLoginFailWithUnknownUsername() {
        login("classpath:shiro.ini", u1.getUsername() + "1", password);
    }

    @Test(expected = IncorrectCredentialsException.class)
    public void testLoginFailWhithErrorPassword() {
        login("classpath:shiro.ini", u1.getUsername(), password + "1");
    }

    @Test(expected = ExcessiveAttemptsException.class)
    public void testLoginFailWithLimitRetryCount() {
        for (int i = 0; i < 5; i++) {
            try {
                login("classpath:shiro.ini", u3.getUsername(), password + "1");
            } catch (Exception e) {}
            login("classpath:shiro.ini", u3.getUsername(), password + "1");
        }
    }

    @Test
    public void testHasRole() {
        login("classpath:shiro.ini", u1.getUsername(), password);
        org.junit.Assert.assertTrue(subject().hasRole("admin"));
    }

    @Test
    public void testNoRole() {
        login("classpath:shiro.ini", u2.getUsername(), password);
        org.junit.Assert.assertTrue(subject().hasRole("admin"));
    }

    @Test
    public void testHasPermission() {
        login("classpath:shiro.ini", u1.getUsername(), password);
        org.junit.Assert.assertTrue(subject().isPermittedAll("user:create", "menu:create"));
    }

    @Test
    public void testNoPermission() {
        login("classpath:shiro.ini", u2.getUsername(), password);
        org.junit.Assert.assertTrue(subject().isPermitted("user:create"));
    }
}
