package kg.zllloy.jobsearch.dao;

import kg.zllloy.jobsearch.dao.mappers.UserMapper;
import kg.zllloy.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

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

    public Optional<User> getUserById(int id) {
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


    public boolean existById(int applicantId) {
        String sql = "SELECT COUNT(*) FROM users WHERE id = ?";
        MapSqlParameterSource params = new MapSqlParameterSource();

        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return count == null || count <= 0;
    }

    public boolean existByName(String name) {
        String sql = "SELECT COUNT(*) FROM users WHERE NAME ilike :name;";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", "%" + name + "%");
        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return count != null && count > 0;
    }

    public boolean existByPhone(String phone) {
        String sql = "SELECT COUNT(*) FROM users WHERE phone_number = ?";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("phone", "%" + phone + "%");
        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return count != null && count > 0;
    }

    public boolean existByEmail(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("email", "%" + email + "%");
        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return count != null && count > 0;
    }
}
