package org.cbillow.shiro.realm;

import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.cbillow.shiro.BaseTest;
import org.cbillow.shiro.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

/**
 * @author Created by Cbillow
 * @date 16/3/13
 * @time 23:41
 */
public class PrincialCollectionTest extends BaseTest {

    @Test
    public void test() {

        //因为Realm里面没有验证，所以相当于每个Realm都身份验证成功了
        login("classpath:shiro.ini", u1.getUsername(), password);
        Subject subject = subject();
        //获取primary principal（第一个）
        Object p1 = subject.getPrincipal();
        PrincipalCollection principals = subject.getPrincipals();
        Object p2 = principals.getPrimaryPrincipal();

        //但是因为多个Realm都返回了Principal，所以此处到底是哪个不确定
        Assert.assertEquals(p1, p2);


        //返回 a b c
        Set<String> realmNames = principals.getRealmNames();
        System.out.println(realmNames);

        //因为MyRealm1和MyRealm2返回的凭据都是zhang，所以排重了
        Set<Object> ps = principals.asSet();
        System.out.println(ps);

        //根据Realm名字获取
        Collection<User> users = principals.fromRealm("c");
        System.out.println(users);
    }
}
