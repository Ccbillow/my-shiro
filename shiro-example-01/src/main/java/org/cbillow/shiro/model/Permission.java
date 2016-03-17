package org.cbillow.shiro.model;

/**
 * @author Created by Cbillow
 * @date 16/3/12
 * @time 21:31
 */
public class Permission {
    private Long id;
    private String permission;
    private String description;
    private Boolean available = Boolean.FALSE;

    public Permission() {
    }

    public Permission(String permission, String description, Boolean available) {
        this.available = available;
        this.description = description;
        this.permission = permission;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "available=" + available +
                ", id=" + id +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
