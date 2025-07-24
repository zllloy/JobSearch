package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.VacancyDao;
import kg.zllloy.jobsearch.dto.VacancyDto;
import kg.zllloy.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyDao vacancyDao;

    @Override
    public List<VacancyDto> getVacanciesByApplicant(int applicantId) {
        return List.of();
    }

    @Override
    public List<VacancyDto> getAllVacancies() {
        return vacancyDao.getAllVacancies();
    }

    @Override
    public List<VacancyDto> getVacanciesByCategory(int categoryId) {
        return vacancyDao.getVacanciesByCategory(categoryId);
    }

}
