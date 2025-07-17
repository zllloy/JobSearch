package kg.zllloy.jobsearch.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Messages {
    private Integer id;
    private Integer respondedApplicants;
    private String content;
    private Timestamp timestamp;
}
