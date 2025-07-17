package kg.zllloy.jobsearch.model;

import lombok.Data;

@Data
public class Categories {
    private Integer id;
    private String name;
    private Integer parentId;
}
