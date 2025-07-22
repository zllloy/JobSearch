package kg.zllloy.jobsearch.dto;

import lombok.Data;

@Data
public class RespondedApplicantsDto {
    private Integer id;
    private Integer resumeId;
    private Integer vacancyId;
    private Boolean confirmation;
}
