package kg.zllloy.jobsearch.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationDto {
    private String institution;
    private String program;
    private LocalDate startDate;
    private LocalDate endDate;
    private String degree;
}
