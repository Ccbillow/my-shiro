package org.cbillow.shiro.model;

/**
 * 用户角色关系
 * @author Created by Cbillow
 * @date 16/3/12
 * @time 21:34
 */
public class UserRole {

    private Long roleId;
    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (roleId != null ? !roleId.equals(userRole.roleId) : userRole.roleId != null) return false;
        return !(userId != null ? !userId.equals(userRole.userId) : userRole.userId != null);

    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
