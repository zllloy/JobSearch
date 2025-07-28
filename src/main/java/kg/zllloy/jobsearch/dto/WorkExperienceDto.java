package kg.zllloy.jobsearch.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class WorkExperienceDto {

    @Min(value = 0, message = "Опыт работы не может быть отрицательным")
    private Integer years;

    @NotBlank(message = "Имя компании не может быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    private String companyName;

    @NotBlank(message = "Должность не может быть пустой")
    @Size(min = 2, max = 50, message = "Должность должна содержать от 2 до 50 символов")
    private String position;

    @NotBlank(message = "Заполните свои обязанности которыми вы занимались")
    @Size(min = 2, max = 50, message = "Размер должен содержать от 2 до 50 символов")
    private String responsibilities;
}