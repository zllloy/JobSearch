package kg.zllloy.jobsearch.dao;

import kg.zllloy.jobsearch.dto.VacancyDto;
import kg.zllloy.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<VacancyDto> getAllVacancies() {
        String sql = "select * from VACANCIES";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(VacancyDto.class));
    }


//    public List<VacancyDto> getVacanciesByApplicant(int resumeId) {
//        String sql = "SELECT * FROM RESPONDED_APPLICANTS WHERE RESUME_ID = :resumeId";
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("resume_id", resumeId);
//
//        return namedParameterJdbcTemplate.query(sql, params, new ResumeMapper());
//    }
}
