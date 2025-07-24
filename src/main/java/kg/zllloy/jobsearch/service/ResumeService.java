package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.ResumeDto;

import java.util.List;

public interface ResumeService {
    List<ResumeDto> getResumesByCategory(int categoryId);

    List<ResumeDto> getResumesByApplicant(int applicantId);

    ResumeDto getResumeById(int resumeId);

    void editResume(int resumeId, ResumeDto resumeDto);

    void deleteResume(int resumeId, int applicantId);
}


