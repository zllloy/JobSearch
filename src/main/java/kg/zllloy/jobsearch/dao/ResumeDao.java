package kg.zllloy.jobsearch.dao;

import kg.zllloy.jobsearch.model.Resumes;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ResumeDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Resumes> getResumeByCategory(int categoryId) {
        String sql = "select * from categories where ID = :categoryId";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resumes.class));
    }

}
