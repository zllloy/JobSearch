package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.dto.JobDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    public List<JobDto> getAllJobs;

    public JobDto getJobById(int jobId) {
        return null;
    }

    public void addJob(JobDto jobDto) {
    }

    public boolean deleteJob(int id) {
        return false;
    }

    public void editJob(JobDto jobDto) {
    }

    public List<JobDto> getAllJobs() {
        return null;
    }

    public boolean existsById(int jobId) {
        return false;
    }

    public void responseToJob(int responseId, int applicantId, JobDto jobDto) {
    }
}
