package kg.zllloy.jobsearch.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResumeDto {
    private int id;
    private int applicantId;
    private String name;
    private int categoryId;
    private double salary;
    private boolean active;
    private Date createdDate;
    private Date updateDate;
}
