package kg.zllloy.jobsearch.dao.mappers;


import kg.zllloy.jobsearch.dto.VacancyDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VacancyMapper implements RowMapper<VacancyDto> {
    @Override
    public VacancyDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        VacancyDto vacancyDto = new VacancyDto();


        return vacancyDto;
    }


}
