package kg.zllloy.jobsearch.model;

import lombok.Data;

@Data
public class RespondedApplicants {
    private Integer id;
    private Integer resumeId;
    private Integer vacancyId;
    private Boolean confirmation;
}


