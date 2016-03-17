package org.cbillow.shiro.service;

import org.cbillow.shiro.model.User;

import java.util.Set;

/**
 * @author Created by Cbillow
 * @date 16/3/12
 * @time 22:19
 */
public interface UserService {

    public User createUser(User user);

    public void changePassword(Long userId, String newPassword);

    public void correlationRoles(Long userId, Long... roleIds);

    public void uncorrelationRoles(Long userId, Long... roleIds);

    public User findByUsername(String username);

    public Set<String> findRoles(String username);

    public Set<String> findPermissions(String username);
}
