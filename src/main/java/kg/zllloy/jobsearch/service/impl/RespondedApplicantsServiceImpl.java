package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.RespondedApplicantsDao;
import kg.zllloy.jobsearch.dto.RespondedApplicantsDto;
import kg.zllloy.jobsearch.service.RespondedApplicantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RespondedApplicantsServiceImpl implements RespondedApplicantsService {
    private final RespondedApplicantsDao respondedApplicantsDao;

    @Override
    public List<RespondedApplicantsDto> getVacanciesByApplicant(int resumeId) {
        return respondedApplicantsDao.getVacanciesByApplicant(resumeId);
    }

    @Override
    public List<RespondedApplicantsDto> getRespondedApplicantsByVacancyId(int vacancyId) {
        return respondedApplicantsDao.getRespondedApplicantsByVacancyId(vacancyId);
    }
}
