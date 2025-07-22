package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.ResumeDao;
import kg.zllloy.jobsearch.dto.JobDto;
import kg.zllloy.jobsearch.dto.ResumeDto;
import kg.zllloy.jobsearch.model.Resumes;
import kg.zllloy.jobsearch.service.ResumeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    private final ResumeDao resumeDao;

    public ResumeServiceImpl(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    public ResumeDto getResumeById(int resumeId) {
        return null;
    }

    public void editResume(int resumeId, ResumeDto resumeDto) {
    }

    public void addResume(int applicantId, ResumeDto resumeDto) {
    }

    public boolean deleteResume(int resumeId) {
        return false;
    }

    public List<JobDto> getAllResumes() {
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
}
