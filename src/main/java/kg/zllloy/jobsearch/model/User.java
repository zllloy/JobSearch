package kg.zllloy.jobsearch.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String username;
    private Integer age;
    private String email;
    private String password;
    private String phoneNumber;
    private String avatar;
    private String accountType;
}
