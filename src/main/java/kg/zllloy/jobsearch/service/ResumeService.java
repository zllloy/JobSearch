package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.ResumeDto;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface ResumeService {
    List<ResumeDto> getResumesByCategory(int categoryId);

    List<ResumeDto> getResumesByApplicant(int applicantId);

    ResumeDto getResumeById(int resumeId);

    void editResume(int resumeId, ResumeDto resumeDto) throws AccessDeniedException;

    void deleteResume(int resumeId, int applicantId);
}


