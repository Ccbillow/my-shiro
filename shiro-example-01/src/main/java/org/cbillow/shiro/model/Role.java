package org.cbillow.shiro.model;

/**
 * @author Created by Cbillow
 * @date 16/3/12
 * @time 21:29
 */
public class Role {
    private Long id;
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;

    public Role() {
    }

    public Role( String role, String description, Boolean available) {
        this.description = description;
        this.available = available;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "available=" + available +
                ", id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return !(id != null ? !id.equals(role.id) : role.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
