package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.ApplicantDto;

import java.util.List;

public interface ApplicantService {
    public List<ApplicantDto> getApplicantsByJob(int jobId);
}
