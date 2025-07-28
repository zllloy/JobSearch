package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.CategoryDao;
import kg.zllloy.jobsearch.dao.ResumeDao;
import kg.zllloy.jobsearch.dao.UserDao;
import kg.zllloy.jobsearch.dto.VacancyDto;
import kg.zllloy.jobsearch.dto.ResumeDto;
import kg.zllloy.jobsearch.exceptions.CategoryNotFoundException;
import kg.zllloy.jobsearch.exceptions.ResumeNotFoundException;
import kg.zllloy.jobsearch.exceptions.UserNotFoundException;
import kg.zllloy.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    private final ResumeDao resumeDao;
    private final CategoryDao categoryDao;
    private final UserDao userDao;

    public ResumeDto getResumeById(int resumeId) {
        if (resumeId <= 0) {
            throw new IllegalArgumentException("ID резюме должно быть положительным");
        }

        if (resumeDao.existById(resumeId)) {
            throw new ResumeNotFoundException();
        }

        return resumeDao.getResumeById(resumeId)
                .orElseThrow(ResumeNotFoundException::new);
    }

    public void editResume(int resumeId, ResumeDto resumeDto) throws AccessDeniedException {
        if (resumeId <= 0) {
            throw new IllegalArgumentException("ID резюме должно быть положительным");
        }

        if (resumeDto == null) {
            throw new IllegalArgumentException("Данные резюме не могут быть null");
        }

        if (resumeDao.existById(resumeId)) {
            throw new ResumeNotFoundException();
        }

        if (categoryDao.existsById(resumeDto.getCategoryId())) {
            throw new CategoryNotFoundException("Категория не найдена");
        }

        if (userDao.existById(resumeDto.getApplicantId())) {
            throw new UserNotFoundException();
        }

        if (!resumeDao.isResumeBelongsToApplicant(resumeId, resumeDto.getApplicantId())) {
            throw new AccessDeniedException("Резюме не принадлежит указанному соискателю");
        }

        resumeDao.editResume(resumeId, resumeDto);
    }

    public void addResume(int applicantId, ResumeDto resumeDto) {
        if (applicantId <= 0) {
            throw new IllegalArgumentException("ID соискателя должен быть положительным");
        }

        if (resumeDto == null) {
            throw new IllegalArgumentException("Данные резюме не могут быть null");
        }

        if (userDao.existById(applicantId)) {
            throw new UserNotFoundException();
        }


        resumeDao.addResume(applicantId, resumeDto);
    }

    public void deleteResume(int resumeId, int applicantId) {

        if (applicantId <= 0) {
            throw new IllegalArgumentException("ID соискателя должен быть положительным");
        }

        if (resumeId <= 0) {
            throw new IllegalArgumentException("ID резюме должен быть положительным");
        }

        if (userDao.existById(applicantId)) {
            throw new UserNotFoundException();
        }

        if (resumeDao.existById(resumeId)) {
            throw new ResumeNotFoundException();
        }

        resumeDao.deleteResume(resumeId, applicantId);
    }

    public List<VacancyDto> getAllResumes() {
        return null;
    }

    @Override
    public List<ResumeDto> getResumesByCategory(int categoryId) {

        if (categoryId <= 0) {
            throw new IllegalArgumentException("ID соискателя должен быть положительным");
        }

        if (categoryDao.existsById(categoryId)) {
            throw new CategoryNotFoundException("Категория по такому айди не найдена");
        }

        return resumeDao.getResumeByCategory(categoryId);
    }

    @Override
    public List<ResumeDto> getResumesByApplicant(int applicantId) {

        if (applicantId <= 0) {
            throw new IllegalArgumentException("ID соискателя должен быть положительным");
        }

        if (userDao.existById(applicantId)) {
            throw new UserNotFoundException();
        }

        return resumeDao.getResumeByApplicant(applicantId);
    }
}
