package kg.zllloy.jobsearch.dao;

import kg.zllloy.jobsearch.dao.mappers.ResumeMapper;
import kg.zllloy.jobsearch.dto.ResumeDto;
import kg.zllloy.jobsearch.exceptions.ResumeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ResumeDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ResumeDto> getResumeByCategory(int categoryId) {
        String sql = "SELECT * FROM RESUMES WHERE CATEGORY_ID = :categoryId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("categoryId", categoryId);

        return namedParameterJdbcTemplate.query(sql, params, new ResumeMapper());
    }

    public List<ResumeDto> getResumeByApplicant(int applicantId) {
        String sql = "SELECT * FROM RESUMES WHERE APPLICANT_ID = :applicantId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("applicantId", applicantId);

        return namedParameterJdbcTemplate.query(sql, params, new ResumeMapper());
    }

    public ResumeDto getResumeById(int resumeId) {
        String sql = "SELECT * FROM RESUMES WHERE ID = :resumeId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("resumeId", resumeId);

        return namedParameterJdbcTemplate.queryForObject(sql, params, new ResumeMapper());
    }

    @Transactional
    public void editResume(int resumeId, ResumeDto resumeDto) {
        String sql = "SELECT COUNT(*) FROM resumes WHERE id = :resumeId";
        Integer count = namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("resumeId", resumeId),
                Integer.class
        );

        if (count == null || count == 0) {
            throw new ResumeNotFoundException("Резюме с ID " + resumeId + " не найдено");
        }

        String updateSql = """
        UPDATE resumes 
        SET name = :name,
            category_id = :categoryId,
            salary = :salary,
            is_active = :isActive,
            update_time = CURRENT_TIMESTAMP
        WHERE id = :resumeId
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("resumeId", resumeId)
                .addValue("name", resumeDto.getName())
                .addValue("categoryId", resumeDto.getCategoryId())
                .addValue("salary", resumeDto.getSalary())
                .addValue("isActive", resumeDto.isActive());

        int updated = namedParameterJdbcTemplate.update(updateSql, params);

        if (updated == 0) {
            throw new RuntimeException("Не удалось обновить резюме");
        }
    }

    @Transactional
    public void deleteResume(int resumeId, int applicantId) {
        String sql = """
            SELECT COUNT(*) FROM resumes 
            WHERE id = :resumeId AND applicant_id = :applicantId
            """;

        MapSqlParameterSource checkParams = new MapSqlParameterSource()
                .addValue("resumeId", resumeId)
                .addValue("applicantId", applicantId);

        Integer count = namedParameterJdbcTemplate.queryForObject(
                sql, checkParams, Integer.class);


        if (count == null || count == 0) {
            throw new ResumeNotFoundException("Резюме с таким id не найдено.");
        }

        String deleteSql = "DELETE FROM resumes WHERE id = :resumeId";
        namedParameterJdbcTemplate.update(deleteSql, checkParams);
    }
}
