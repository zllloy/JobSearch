package kg.zllloy.jobsearch.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class RespondedUserDto {

    @NotNull(message = "resumeId не может быть null")
    @Min(value = 1, message = "resumeId не может быть отрицательным или нулевым")
    private Integer resumeId;

    @Min(value = 0, message = "vacancyId не может быть отрицательным или нулевым")
    private Integer vacancyId;
    private Boolean confirmation;
}
