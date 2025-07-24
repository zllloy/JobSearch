package kg.zllloy.jobsearch.dao.mappers;

import kg.zllloy.jobsearch.dto.ResumeDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResumeMapper implements RowMapper<ResumeDto> {
    @Override
    public ResumeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResumeDto dto = new ResumeDto();
        dto.setId(rs.getInt("id"));
        dto.setApplicantId(rs.getInt("applicant_id"));
        dto.setName(rs.getString("name"));
        dto.setCategoryId(rs.getInt("category_id"));
        dto.setSalary(rs.getDouble("salary"));
        dto.setActive(rs.getBoolean("is_active"));
        dto.setCreatedDate(rs.getDate("created_date"));
        dto.setUpdateTime(rs.getDate("update_time"));
        return dto;
    }
}
