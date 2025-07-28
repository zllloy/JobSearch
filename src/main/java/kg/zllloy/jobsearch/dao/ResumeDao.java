package kg.zllloy.jobsearch.dao;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import kg.zllloy.jobsearch.dao.mappers.ResumeMapper;
import kg.zllloy.jobsearch.dto.ResumeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ResumeDao {
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

    public Optional<ResumeDto> getResumeById(int resumeId) {
        String sql = "SELECT * FROM RESUMES WHERE ID = :resumeId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("resumeId", resumeId);

        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        namedParameterJdbcTemplate.query(sql, params, new ResumeMapper())
                )
        );
    }

    @Transactional
    public void editResume(int resumeId, ResumeDto resumeDto) {
        String updateSql = """
                 UPDATE resumes\s
                 SET name = :name,
                     category_id = :categoryId,
                     salary = :salary,
                     is_active = :isActive,
                     update_time = CURRENT_TIMESTAMP
                 WHERE id = :resumeId
                \s""";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("resumeId", resumeId)
                .addValue("name", resumeDto.getName())
                .addValue("categoryId", resumeDto.getCategoryId())
                .addValue("salary", resumeDto.getSalary())
                .addValue("isActive", resumeDto.isActive());

        namedParameterJdbcTemplate.update(updateSql, params);
    }

    @Transactional
    public void deleteResume(int resumeId, int applicantId) {

        MapSqlParameterSource checkParams = new MapSqlParameterSource()
                .addValue("resumeId", resumeId)
                .addValue("applicantId", applicantId);


        String deleteSql = "DELETE FROM resumes WHERE id = :resumeId";
        namedParameterJdbcTemplate.update(deleteSql, checkParams);
    }

    @Transactional
    public void addResume(int applicantId, ResumeDto resumeDto) {
        String insertSql = """
                 INSERT INTO resumes (
                     applicant_id,\s
                     name,\s
                     category_id,\s
                     salary,\s
                     is_active,\s
                     created_date
                 ) VALUES (
                     :applicantId,\s
                     :name,\s
                     :categoryId,\s
                     :salary,\s
                     :isActive,\s
                     :createdDate
                 )\s
                \s""";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("applicantId", applicantId)
                .addValue("name", resumeDto.getName())
                .addValue("categoryId", resumeDto.getCategoryId())
                .addValue("salary", resumeDto.getSalary())
                .addValue("isActive", resumeDto.isActive())
                .addValue("createdDate", LocalDateTime.now());

        namedParameterJdbcTemplate.update(insertSql, params);

    }

    public boolean isResumeBelongsToApplicant(
            @NotNull(message = "resumeId не может быть null")
            @Min(value = 1, message = "resumeId не может быть отрицательным или нулевым")
            int resumeId,
            @NotNull(message = "applicantId не может быть null")
            @Min(value = 1, message = "applicantId не может быть отрицательным или нулевым")
            Integer applicantId) {

        String sql = "SELECT COUNT(*) FROM resumes WHERE id = :resumeId AND applicant_id = :applicantId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("resumeId", resumeId);
        params.addValue("applicantId", applicantId);

        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return count != null && count > 0;
    }


    public boolean existById(int resumeId) {
        String sql = "SELECT COUNT(*) FROM RESUMES WHERE ID = :resumeId";
        MapSqlParameterSource params = new MapSqlParameterSource("resumeId", resumeId);

        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return count == null || count <= 0;
    }

}
