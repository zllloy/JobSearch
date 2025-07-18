package kg.zllloy.jobsearch.dao.mappers;

import kg.zllloy.jobsearch.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        int age = rs.getInt("age");
        user.setAge(rs.wasNull() ? 0 : age);
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setAvatar(rs.getString("avatar"));
        user.setAccountType(rs.getString("account_type"));
        return user;
    }
}
