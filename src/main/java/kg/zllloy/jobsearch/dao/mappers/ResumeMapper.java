package kg.zllloy.jobsearch.dao.mappers;

import kg.zllloy.jobsearch.dto.ResumeDto;
import kg.zllloy.jobsearch.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResumeMapper implements RowMapper<ResumeDto> {
    @Override
    public ResumeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResumeDto dto = new ResumeDto();
        dto.setId(rs.getInt("id"));
        dto.setFullName(rs.getString("full_name"));
        dto.setPosition(rs.getString("position"));
        return dto;
    }
}
