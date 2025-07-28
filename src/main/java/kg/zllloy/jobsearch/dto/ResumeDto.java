package kg.zllloy.jobsearch.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ResumeDto {
    @NotNull(message= "applicantId не может быть null")
    @Min(value = 1, message = "resumeId не может быть отрицательным или нулевым")
    private Integer applicantId;

    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    private String name;

    @NotNull(message= "applicantId не может быть null")
    @Min(value = 1, message = "resumeId не может быть отрицательным или нулевым")
    private Integer categoryId;

    @Min(value = 1, message = "поле с зарплатой не может быть отрицательным или нулевым")
    private double salary;

    @NotNull(message = "Активность резюме обязательна")
    private boolean active;

    @PastOrPresent(message = "Дата создания должна быть в прошлом или сегодня")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @PastOrPresent(message = "Дата обновления должна быть в прошлом или сегодня")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private List<EducationDto> educations;
    private List<WorkExperienceDto> workExperiences;
}
