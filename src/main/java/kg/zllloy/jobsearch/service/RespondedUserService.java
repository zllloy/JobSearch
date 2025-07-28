package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.RespondedUserDto;

import java.util.List;

public interface RespondedUserService {
    public List<RespondedUserDto> getVacanciesByApplicant(int resumeId);

    public List<RespondedUserDto>getRespondedApplicantsByVacancyId(int vacancyId);
}
