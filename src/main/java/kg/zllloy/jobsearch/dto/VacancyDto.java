package kg.zllloy.jobsearch.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VacancyDto {
    private String name;
    private String description;
    private Integer categoryId;
    private Integer salary;
    private String expForm;
    private String expTo;
    private Boolean isActive;
    private Integer authorId;
    private Date createdDate;
    private Date updatedDate;
}
