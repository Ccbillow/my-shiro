package org.cbillow.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author Created by Cbillow
 * @date 16/3/11
 * @time 20:28
 */
public class TestEncode {

    private Subject login(String username, String password) {
        SecurityManager manager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testEncode() {
        /**
         *
         * 加密需要传入盐值
         * 确保密码唯一
         */
        System.out.println(new Md5Hash("123", "user").toHex());
    }

    @Test
    public void testPasswordService() throws Exception {
        PasswordService service = new DefaultPasswordService();
        String str = service.encryptPassword("123");
        String str1 = service.encryptPassword("123");
        boolean result = service.passwordsMatch("123", str);

        System.out.println("[这种做法不对！]通过equals比较：" + str.equals(str1));
        System.out.println("通过passwordsMatch比较：" + result);
    }

    @Test
    public void testPasswordTestRealm() {
        login("kh", "123");
    }
}
