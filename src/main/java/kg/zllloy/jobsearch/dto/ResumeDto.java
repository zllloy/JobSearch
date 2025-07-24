package kg.zllloy.jobsearch.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ResumeDto {
    private int id;
    private int applicantId;
    private String name;
    private int categoryId;
    private double salary;
    private boolean active;
    private Date createdDate;
    private Date updateTime;
    private List<EducationDto> educations;
    private List<WorkExperienceDto> workExperiences;
}
