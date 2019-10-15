package com.example.demo.mapper;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.demo.models.User;
import org.springframework.jdbc.core.RowMapper;
 
public class UserMapper implements RowMapper<User> {
 
    public static final String BASE_SQL //
            = "Select u.id, u.user_name, u.password, u.email From user u ";
 
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        Long userId = rs.getLong("id");
        String userName = rs.getString("user_name");
        String encrytedPassword = rs.getString("password");
        String email=rs.getString("email");
        return new User(userId, userName, encrytedPassword,email);
    }
 
}