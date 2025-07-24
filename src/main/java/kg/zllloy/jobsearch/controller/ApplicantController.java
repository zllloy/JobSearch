package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.ApplicantDto;
import kg.zllloy.jobsearch.service.impl.ApplicantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applicants")
public class ApplicantController {
    private final ApplicantServiceImpl applicantService;

    @GetMapping("/{applicantId}")
    public ResponseEntity<ApplicantDto> getApplicant(@PathVariable int applicantId) {
        ApplicantDto applicant = applicantService.getApplicantById(applicantId);
        if (applicant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(applicant);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicantDto>> getApplicantsByJob(@PathVariable int jobId) {
        List<ApplicantDto> applicants = applicantService.getApplicantsByJob(jobId);
        if (applicants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(applicants);
    }
}
