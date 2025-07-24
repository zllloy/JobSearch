package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.RespondedApplicantsDto;

import java.util.List;

public interface RespondedApplicantsService {
    public List<RespondedApplicantsDto> getVacanciesByApplicant(int resumeId);

    public List<RespondedApplicantsDto>getRespondedApplicantsByVacancyId(int vacancyId);
}
