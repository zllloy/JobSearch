package kg.zllloy.jobsearch.dao;

import kg.zllloy.jobsearch.dao.mappers.VacancyMapper;
import kg.zllloy.jobsearch.dto.VacancyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<VacancyDto> getAllVacancies() {
        String sql = "select * from VACANCIES";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(VacancyDto.class));
    }

    public List<VacancyDto> getVacanciesByCategory(int categoryId) {
        String sql = "SELECT * FROM vacancies WHERE category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(VacancyDto.class), categoryId);
    }

    public List<VacancyDto> getVacanciesByApplicant(int applicantId) {
        String sql = "SELECT * FROM RESPONDED_APPLICANTS WHERE RESUME_ID = :resumeId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("resume_id", applicantId);

        return namedParameterJdbcTemplate.query(sql, params, new VacancyMapper());
    }

    public Optional<VacancyDto> getVacancyById(int vacancyId) {
        String sql = "SELECT * FROM vacancies WHERE ID = :vacancyId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("vacancyId", vacancyId);

        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        namedParameterJdbcTemplate.query(sql, params, new VacancyMapper())
                )
        );
    }

    @Transactional
    public void editVacancy(int vacancyId, VacancyDto vacancyDto) {
        String updateSql = """
         UPDATE vacancies
         SET name = :name,
             description = :description,
             category_id = :categoryId,
             salary = :salary,
             exp_from = :expFrom,
             exp_to = :expTo,
             is_active = :isActive,
             update_time = CURRENT_TIMESTAMP
         WHERE id = :vacancyId
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("vacancyId", vacancyId)
                .addValue("name", vacancyDto.getName())
                .addValue("description", vacancyDto.getDescription())
                .addValue("categoryId", vacancyDto.getCategoryId())
                .addValue("salary", vacancyDto.getSalary())
                .addValue("expFrom", vacancyDto.getExpFrom())
                .addValue("expTo", vacancyDto.getExpTo())
                .addValue("isActive", vacancyDto.getActive());

        namedParameterJdbcTemplate.update(updateSql, params);
    }

    @Transactional
    public void deleteVacancy(int vacancyId, int authorId) {
        String deleteSql = """
        DELETE FROM vacancies
        WHERE id = :vacancyId AND author_id = :authorId
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("vacancyId", vacancyId)
                .addValue("authorId", authorId);

        namedParameterJdbcTemplate.update(deleteSql, params);
    }

    @Transactional
    public void addVacancy(int applicantId, VacancyDto vacancyDto) {
        String insertSql = """
        INSERT INTO resumes (
            applicant_id,
            name,
            category_id,
            salary,
            is_active,
            created_date
        ) VALUES (
            :applicantId,
            :name,
            :categoryId,
            :salary,
            :isActive,
            :createdDate
        )
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", vacancyDto.getName())
                .addValue("description", vacancyDto.getDescription())
                .addValue("categoryId", vacancyDto.getCategoryId())
                .addValue("salary", vacancyDto.getSalary())
                .addValue("expFrom", vacancyDto.getExpFrom())
                .addValue("expTo", vacancyDto.getExpTo())
                .addValue("isActive", vacancyDto.getActive());

        namedParameterJdbcTemplate.update(insertSql, params);
    }

    public boolean existById(int vacancyId) {
        String sql = "SELECT COUNT(*) FROM vacancies WHERE ID = :vacancyId";
        MapSqlParameterSource params = new MapSqlParameterSource("vacancyId", vacancyId);

        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return count != null && count > 0;
    }

    public boolean isVacancyBelongsToAuthor(int vacancyId, int authorId) {
        String sql = """
        SELECT COUNT(*) FROM vacancies 
        WHERE id = :vacancyId AND author_id = :authorId
    """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("vacancyId", vacancyId)
                .addValue("authorId", authorId);

        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return count == null || count <= 0;
    }

}
