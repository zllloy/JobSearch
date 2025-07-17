package kg.zllloy.jobsearch.model;

import lombok.Data;

@Data
public class WorkExperienceInfo {
    private Integer id;
    private Integer resumeId;
    private Integer years;
    private String companyName;
    private String position;
    private String responsibilities;
}
