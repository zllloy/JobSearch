package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.VacancyDto;

import java.util.List;

public interface VacancyService {
    public List<VacancyDto> getVacanciesByApplicant(int applicantId);

    public List<VacancyDto> getAllVacancies();

    public List<VacancyDto> getVacanciesByCategory(int category);
}
