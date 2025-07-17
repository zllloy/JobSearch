package kg.zllloy.jobsearch.model;

import lombok.Data;

import java.util.Date;

@Data
public class EducationInfo {
    private Integer id;
    private Integer resumeId;
    private String institution;
    private String program;
    private Date startDate;
    private Date endDate;
    private String degree;
}
