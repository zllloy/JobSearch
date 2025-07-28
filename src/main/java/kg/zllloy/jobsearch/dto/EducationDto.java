package kg.zllloy.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationDto {
    @NotBlank(message = "Имя пользователя не должно быть пустым")
    private String username;

    @NotBlank(message = "Напишите имя института в котором вы учитесь или учились когда-то")
    private String institution;

    private String program;

    @PastOrPresent(message = "Дата начала обучения должна быть в прошлом или сегодня")
    private LocalDate startDate;

    @PastOrPresent(message = "Дата окончания должна быть в прошлом или сегодня")
    private LocalDate endDate;

    private String degree;
}
