package kg.zllloy.jobsearch.dao;

import kg.zllloy.jobsearch.dao.mappers.RespondedUserMapper;
import kg.zllloy.jobsearch.dto.RespondedUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RespondedUserDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<RespondedUserDto> getVacanciesByApplicant(int resumeId) {
        String sql = "SELECT * FROM RESPONDED_APPLICANTS WHERE RESUME_ID = :resumeId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("resumeId", resumeId);

        return namedParameterJdbcTemplate.query(sql, params, new RespondedUserMapper());
    }

    public List<RespondedUserDto> getRespondedApplicantsByVacancyId(int vacancyId) {
        String sql = "SELECT * FROM RESPONDED_APPLICANTS WHERE VACANCY_ID  = ?";
        return jdbcTemplate.query(sql, new RespondedUserMapper(), vacancyId);
    }

}
