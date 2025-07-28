package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.ResumeDao;
import kg.zllloy.jobsearch.dto.VacancyDto;
import kg.zllloy.jobsearch.dto.ResumeDto;
import kg.zllloy.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    private final ResumeDao resumeDao;

    public ResumeDto getResumeById(int resumeId) {
        return resumeDao.getResumeById(resumeId);
    }

    public void editResume(int resumeId, ResumeDto resumeDto) {
        resumeDao.editResume(resumeId, resumeDto);
    }

    public void addResume(int applicantId, ResumeDto resumeDto) {
        resumeDao.addResume(applicantId, resumeDto);
    }

    public void deleteResume(int resumeId, int applicantId) {
        resumeDao.deleteResume(resumeId, applicantId);
    }

    public List<VacancyDto> getAllResumes() {
        return null;
    }

    public boolean existsById(int resumeId) {
        return false;
    }

    public void addResponse(int jobId, int resumeId) {
    }

    @Override
    public List<ResumeDto> getResumesByCategory(int categoryId) {
        return resumeDao.getResumeByCategory(categoryId);
    }

    @Override
    public List<ResumeDto> getResumesByApplicant(int applicantId) {
        return resumeDao.getResumeByApplicant(applicantId);
    }
}
