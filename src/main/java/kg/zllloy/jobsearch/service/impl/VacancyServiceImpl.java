package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.CategoryDao;
import kg.zllloy.jobsearch.dao.UserDao;
import kg.zllloy.jobsearch.dao.VacancyDao;
import kg.zllloy.jobsearch.dto.VacancyDto;
import kg.zllloy.jobsearch.exceptions.CategoryNotFoundException;
import kg.zllloy.jobsearch.exceptions.ForbiddenException;
import kg.zllloy.jobsearch.exceptions.UserNotFoundException;
import kg.zllloy.jobsearch.exceptions.VacancyNotFoundException;
import kg.zllloy.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyDao vacancyDao;
    private final UserDao userDao;
    private final CategoryDao categoryDao;

    @Override
    public List<VacancyDto> getVacanciesByApplicant(int applicantId) {
        if (!userDao.existById(applicantId)) {
            throw new UserNotFoundException();
        }
        return vacancyDao.getVacanciesByApplicant(applicantId);
    }

    @Override
    public List<VacancyDto> getAllVacancies() {
        return vacancyDao.getAllVacancies();
    }

    @Override
    public List<VacancyDto> getVacanciesByCategory(int categoryId) {
        if (!categoryDao.existsById(categoryId)) {
            throw new CategoryNotFoundException("Категория не найдена");
        }
        return vacancyDao.getVacanciesByCategory(categoryId);
    }

    public void addVacancy(int authorId, VacancyDto vacancyDto) {
        if (!userDao.existById(authorId)) {
            throw new UserNotFoundException();
        }
        vacancyDao.addVacancy(authorId, vacancyDto);
    }

    public void editVacancy(int vacancyId, int authorId, VacancyDto vacancyDto) {
        if (vacancyDao.existById(vacancyId)) {
            throw new VacancyNotFoundException();
        }

        if (vacancyDao.isVacancyBelongsToAuthor(vacancyId, authorId)) {
            throw new ForbiddenException("Нет доступа к редактированию этой вакансии");
        }

        vacancyDao.editVacancy(vacancyId, vacancyDto);
    }

    public void deleteVacancy(int vacancyId, int authorId) {
        if (vacancyDao.existById(vacancyId)) {
            throw new VacancyNotFoundException();
        }

        if (vacancyDao.isVacancyBelongsToAuthor(vacancyId, authorId)) {
            throw new ForbiddenException("Нет доступа к удалению этой вакансии");
        }

        vacancyDao.deleteVacancy(vacancyId, authorId);
    }
}

