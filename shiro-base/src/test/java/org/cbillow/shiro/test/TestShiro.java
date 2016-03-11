package org.cbillow.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Created by Cbillow
 * @date 16/3/10
 * @time 13:44
 */
public class TestShiro {

    @Test
    public void testBase() {
        SecurityManager manager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("kh", "123");
        try {
            subject.login(token);
            PrincipalCollection pc = subject.getPrincipals();
            System.out.println(pc.asList());
            System.out.println(pc.getRealmNames());
            System.out.println(subject.getPrincipal( ));
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在！");
        } catch (IncorrectCredentialsException e) {
            System.out.println("用户密码出错！");
        }
    }

    @Test
    public void testRoles() {
        SecurityManager manager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("kh", "123");
        subject.login(token);
        System.out.println(subject.hasRole("r1"));
        System.out.println(subject.hasAllRoles(Arrays.asList("r1", "r2", "r3")));
        System.out.println(subject.hasRoles(Arrays.asList("r1", "r2", "r3"))[0]);
    }

    @Test
    public void testPermission1() {
        SecurityManager manager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("kh", "123");
        subject.login(token);
        System.out.println(subject.isPermitted("user:delete"));
        System.out.println(subject.isPermitted("topic:create"));
        System.out.println(subject.isPermitted("dep:delete"));
    }

    @Test
    public void testPermission2() {
        SecurityManager manager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lisi", "111");
        subject.login(token);
        System.out.println(subject.isPermitted("admin:user:delete"));
        System.out.println(subject.isPermitted("user:view"));
        System.out.println(subject.isPermitted("admin:user:view"));
    }

    @Test
    public void testMyPermission() {
        SecurityManager manager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("kh", "123");
        subject.login(token);
        System.out.println(subject.isPermitted("+user+create"));
        System.out.println(subject.isPermitted("test:delete"));
        System.out.println(subject.isPermitted("classroom:add"));
    }
}
