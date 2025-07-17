package kg.zllloy.jobsearch.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {
    private int id;
    private int jobId;
    private int resumeId;
    private LocalDateTime respondedAt;
}
