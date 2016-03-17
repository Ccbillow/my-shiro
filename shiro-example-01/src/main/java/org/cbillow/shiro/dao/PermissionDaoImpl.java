package org.cbillow.shiro.dao;

import org.cbillow.shiro.JdbcTemplateUtils;
import org.cbillow.shiro.model.Permission;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Created by Cbillow
 * @date 16/3/13
 * @time 22:04
 */
public class PermissionDaoImpl implements PermissionDao {

    private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();

    public Permission createPermission(final Permission permission) {
        final String sql = "insert into sys_permissions(permission, description, available) values(?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement prep = connection.prepareStatement(sql, new String[]{"id"});
                prep.setString(1, permission.getPermission());
                prep.setString(2, permission.getDescription());
                prep.setBoolean(3, permission.getAvailable());
                return prep;
            }
        }, keyHolder);
        permission.setId(keyHolder.getKey().longValue());

        return permission;
    }

    public void deletePermission(Long permissionId) {
        String sql = "delete from sys_roles_permissions where permission_id=?";
        jdbcTemplate.update(sql, permissionId);

        sql = "delete from sys_permissions where id=?";
        jdbcTemplate.update(sql, permissionId);
    }
}
