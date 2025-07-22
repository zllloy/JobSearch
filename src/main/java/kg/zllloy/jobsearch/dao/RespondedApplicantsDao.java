package kg.zllloy.jobsearch.dao;

import kg.zllloy.jobsearch.dao.mappers.RespondedApplicantsMapper;
import kg.zllloy.jobsearch.dao.mappers.ResumeMapper;
import kg.zllloy.jobsearch.dto.RespondedApplicantsDto;
import kg.zllloy.jobsearch.dto.ResumeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RespondedApplicantsDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<RespondedApplicantsDto> getVacanciesByApplicant(int resumeId) {
        String sql = "SELECT * FROM RESPONDED_APPLICANTS WHERE RESUME_ID = :resumeId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("resumeId", resumeId);

        return namedParameterJdbcTemplate.query(sql, params, new RespondedApplicantsMapper());
    }
}
