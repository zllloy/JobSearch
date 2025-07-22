package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.model.Resumes;

import java.util.List;

public interface ResumeService {
    List<Resumes> getResumesOfCategory(int categoryId);
}
