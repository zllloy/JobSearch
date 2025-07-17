package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.JobDto;
import kg.zllloy.jobsearch.dto.ResumeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {
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

    public Object getResumeByCategory(int id) {
        return null;
    }

    public boolean existsById(int resumeId) {
        return false;
    }

    public void addResponse(int jobId, int resumeId) {
    }
}
