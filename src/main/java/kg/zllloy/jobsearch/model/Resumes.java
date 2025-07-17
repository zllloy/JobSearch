package kg.zllloy.jobsearch.model;

import lombok.Data;

import java.util.Date;

@Data
public class Resumes {
    private Integer id;
    private Integer applicantId;
    private String name;
    private Integer categoryId;
    private Float salary;
    private Boolean isActive;
    private Date createdDate;
    private Date updateDate;
}
