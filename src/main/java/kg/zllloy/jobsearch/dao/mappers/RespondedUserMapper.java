package kg.zllloy.jobsearch.dao.mappers;

import kg.zllloy.jobsearch.dto.RespondedUserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RespondedUserMapper implements RowMapper<RespondedUserDto> {

    @Override
    public RespondedUserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        RespondedUserDto dto = new RespondedUserDto();
        dto.setResumeId(rs.getInt("resume_id"));
        dto.setVacancyId(rs.getInt("vacancy_id"));
        dto.setConfirmation(rs.getBoolean("confirmation"));

        return dto;
    }
}
