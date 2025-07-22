package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.ResumeDto;

import java.util.List;

public interface ResumeService {
    List<ResumeDto> getResumesByCategory(int categoryId);
}
