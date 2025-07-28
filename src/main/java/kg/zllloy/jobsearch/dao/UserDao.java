package kg.zllloy.jobsearch.dao;

import kg.zllloy.jobsearch.dao.mappers.UserMapper;
import kg.zllloy.jobsearch.dto.UserDto;
import kg.zllloy.jobsearch.model.User;
import kg.zllloy.jobsearch.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new UserMapper());
    }


    public List<User> findByName(String name) {
        String sql = "select * from users\n" + "where NAME ilike :name;";
        return namedParameterJdbcTemplate.query(
                sql,
                new MapSqlParameterSource()
                        .addValue("name", "%" + name + "%"),
                new UserMapper()
        );
    }

    public List<User> getByPhone(String phone) {
        String sql = "SELECT * FROM users WHERE phone_number = ?";
        return jdbcTemplate.query(sql, new UserMapper(), phone);
    }

    public Optional<User> getByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new UserMapper(), email)
                )
        );
    }

    public Optional<User> getUserById (int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new UserMapper(), id)
                )
        );
    }

    public List<User> getApplicantsByVacancy(int vacancyId) {
        String sql = """
        SELECT u.* 
        FROM responded_applicants ra
        JOIN resumes r ON ra.resume_id = r.id
        JOIN users u ON r.applicant_id = u.id
        WHERE ra.vacancy_id = ?
    """;

        return jdbcTemplate.query(sql, new UserMapper(), vacancyId);
    }



}
