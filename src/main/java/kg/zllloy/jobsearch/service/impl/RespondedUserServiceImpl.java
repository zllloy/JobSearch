package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.RespondedUserDao;
import kg.zllloy.jobsearch.dto.RespondedUserDto;
import kg.zllloy.jobsearch.service.RespondedUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RespondedUserServiceImpl implements RespondedUserService {
    private final RespondedUserDao respondedApplicantsDao;

    @Override
    public List<RespondedUserDto> getVacanciesByApplicant(int resumeId) {
        return respondedApplicantsDao.getVacanciesByApplicant(resumeId);
    }

    @Override
    public List<RespondedUserDto> getRespondedApplicantsByVacancyId(int vacancyId) {
        return respondedApplicantsDao.getRespondedApplicantsByVacancyId(vacancyId);
    }
}
