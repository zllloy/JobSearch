package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.VacancyDto;
import org.springframework.stereotype.Service;

import java.util.List;

public class JobService {
    public List<VacancyDto> getAllJobs;

    public VacancyDto getJobById(int jobId) {
        return null;
    }

    public void addJob(VacancyDto jobDto) {
    }

    public boolean deleteJob(int id) {
        return false;
    }

    public void editJob(VacancyDto jobDto) {
    }

    public List<VacancyDto> getAllJobs() {
        return null;
    }

    public boolean existsById(int jobId) {
        return false;
    }

    public void responseToJob(int responseId, int applicantId, VacancyDto jobDto) {
    }
}
