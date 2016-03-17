package org.cbillow.shiro.model;

/**
 * 用户角色关系
 * @author Created by Cbillow
 * @date 16/3/12
 * @time 21:32
 */
public class RolePermission {

    private Long roleId;
    private Long permissionId;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "permissionId=" + permissionId +
                ", roleId=" + roleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermission that = (RolePermission) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        return !(permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null);

    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
        return result;
    }
}
