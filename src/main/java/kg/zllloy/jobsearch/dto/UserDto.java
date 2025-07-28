package kg.zllloy.jobsearch.dto;

import jakarta.validation.constraints.*;
import kg.zllloy.jobsearch.model.User;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    private String name;

    @NotBlank(message = "Имя пользователя не должно быть пустым")
    @Size(min = 3, max = 30, message = "Имя пользователя должно содержать от 3 до 30 символов")
    private String username;

    @NotNull(message = "Возраст обязателен")
    @Min(value = 14, message = "Минимальный возраст — 14 лет")
    @Max(value = 120, message = "Максимальный возраст — 120 лет")
    private Integer age;

    @NotBlank(message = "Email не должен быть пустым")
    @Email(message = "Неверный формат email")
    private String email;

    @NotBlank
    @Size(min = 6, max = 20, message = ("Длина должна быть не меньше шести символов!"))
    @Pattern(
            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$",
            message = "Пароль должен содержать от 6 до 20 символов, хотя бы одну заглавную букву и одну цифру"
    )
    private String password;

    @Pattern(
            regexp = "^\\+?[0-9]{10,15}$",
            message = "Телефон должен содержать от 10 до 15 цифр и может начинаться с +"
    )
    private String phoneNumber;

    private String avatar;

    @NotBlank(message = "Тип аккаунта обязателен")
    @Pattern(
            regexp = "^(APPLICANT|EMPLOYER)$",
            message = "Тип аккаунта должен быть соискатель или работодатель"
    )
    private String accountType;
}
