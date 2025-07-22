package kg.zllloy.jobsearch.dao.mappers;

import kg.zllloy.jobsearch.dto.RespondedApplicantsDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RespondedApplicantsMapper implements RowMapper<RespondedApplicantsDto> {

    @Override
    public RespondedApplicantsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        RespondedApplicantsDto dto = new RespondedApplicantsDto();
        dto.setId(rs.getInt("id"));
        dto.setResumeId(rs.getInt("resume_id"));
        dto.setVacancyId(rs.getInt("vacancy_id"));
        dto.setConfirmation(rs.getBoolean("confirmation"));

        return dto;
    }
}
