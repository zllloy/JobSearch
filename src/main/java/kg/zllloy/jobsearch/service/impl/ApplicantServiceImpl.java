package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.ApplicantDao;
import kg.zllloy.jobsearch.dto.ApplicantDto;
import kg.zllloy.jobsearch.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantDao applicantDao;

    public List<ApplicantDto> getApplicantsByJob(int jobId) {
//        if (jobId != null) {
//            List<ApplicantDto> applicants = applicantService.getApplicantsByJob(jobId);
//            return applicants.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(applicants);
//        }
//
//        return ResponseEntity.badRequest().build();

        return null;
    }

    public ApplicantDto getApplicantById(int applicantId) {
        return null;
    }
}
