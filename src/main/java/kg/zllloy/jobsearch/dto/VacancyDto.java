package kg.zllloy.jobsearch.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class VacancyDto {
    @NotBlank(message = "Название вакансии не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название должно содержать от 2 до 100 символов")
    private String name;

    @NotBlank(message = "Описание не должно быть пустым")
    @Size(min = 10, max = 1000, message = "Описание должно содержать от 10 до 1000 символов")
    private String description;

    @NotNull(message = "ID категории обязателен")
    @Min(value = 1, message = "ID категории не может быть отрицательным или равным нулю")
    private Integer categoryId;

    @NotNull(message = "Зарплата обязательна")
    @Min(value = 1, message = "Зарплата должна быть больше нуля")
    private Integer salary;

    @Size(max = 50, message = "Опыт работы (с) должен быть не длиннее 50 символов")
    private String expFrom;

    @Size(max = 50, message = "Опыт работы (по) должен быть не длиннее 50 символов")
    private String expTo;

    @NotNull(message = "Активность вакансии обязательна")
    private Boolean active;

    @NotNull(message = "ID автора обязателен")
    @Min(value = 1, message = "ID автора не может быть меньше 1")
    private Integer authorId;

    @PastOrPresent(message = "Дата создания не может быть в будущем")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @PastOrPresent(message = "Дата обновления не может быть в будущем")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedDate;

}
