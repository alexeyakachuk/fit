package com.fit.fit.mapper;

import com.fit.fit.model.User;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getInt("id"))
                .userName(rs.getString("userName"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .createdAt(rs.getTimestamp("created_ad").toLocalDateTime())
                .updatedAt(rs.getTimestamp("update_at").toLocalDateTime())
                .build();
    }
}
