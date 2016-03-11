package org.cbillow.shiro.permission;

import com.google.common.base.Strings;
import org.apache.shiro.authz.Permission;

/**
 * @author Created by Cbillow
 * @date 16/3/11
 * @time 19:23
 */
public class MyPermission implements Permission {
    private String resourceId;
    private String operator;
    private String instanceId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public MyPermission() {
    }

    @Override
    public String toString() {
        return "MyPermission{" +
                "instanceId='" + instanceId + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }

    public MyPermission(String permissionStr) {
        String[] strs = permissionStr.split("\\+");
        if (strs.length > 1) {
            this.setResourceId(strs[1]);
        }
        if (Strings.isNullOrEmpty(this.getResourceId())) {
            this.setResourceId("*");
        }

        if (strs.length > 2) {
            this.setOperator(strs[2]);
        }

        if (strs.length > 3) {
            this.setInstanceId(strs[3]);
        }
        if (Strings.isNullOrEmpty(this.getInstanceId())) {
            this.setInstanceId("*");
        }
    }

    @Override
    public boolean implies(Permission permission) {
        if (!(permission instanceof MyPermission)) return false;
        MyPermission mp = (MyPermission) permission;
        if (!this.getResourceId().equals("*") && !mp.getResourceId().equals(this.getResourceId())) {
            return false;
        }
        if (!this.getOperator().equals("*") && !mp.getOperator().equals(this.getOperator())) {
            return false;
        }
        if (!this.getInstanceId().equals("*") && !mp.getInstanceId().equals(this.getInstanceId())) {
            return false;
        }
        return true;
    }
}
