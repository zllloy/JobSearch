package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.ApplicantDto;
import kg.zllloy.jobsearch.dto.JobDto;
import kg.zllloy.jobsearch.dto.ResumeDto;
import kg.zllloy.jobsearch.service.ApplicantService;
import kg.zllloy.jobsearch.service.JobService;
import kg.zllloy.jobsearch.service.impl.ResumeServiceImpl;
import kg.zllloy.jobsearch.service.SummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {
    private final ResumeServiceImpl resumeServiceImpl;
    private final ApplicantService applicantService;
    private final SummaryService summaryService;
    private final JobService jobService;

    @GetMapping
    public List<JobDto> getAllResumes() {
        return resumeServiceImpl.getAllResumes();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ResumeDto>> getResumeByCategory(@PathVariable int id) {
        List<ResumeDto> resumes = (List<ResumeDto>) resumeServiceImpl.getResumeByCategory(id);
        if (resumes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resumes);
    }

    @PostMapping("/create/{applicantId}")
    public ResponseEntity<Void> createResume(@PathVariable int applicantId, @RequestBody ResumeDto resumeDto) {
        ApplicantDto applicant = applicantService.getApplicantById(applicantId);
        if (applicant == null) {
            return ResponseEntity.notFound().build();
        }

        resumeServiceImpl.addResume(applicantId, resumeDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{resumeId}/applicant/{applicantId}")
    public ResponseEntity<Void> editResume(@PathVariable int resumeId,
                                           @PathVariable int applicantId,
                                           @RequestBody ResumeDto resumeDto) {
        ResumeDto existing = resumeServiceImpl.getResumeById(resumeId);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        if (existing.getApplicantId() != applicantId) {
            return ResponseEntity.status(403).build();
        }
        resumeServiceImpl.editResume(resumeId, resumeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{resumeId}/applicant/{applicantId}")
    public ResponseEntity<Void> deleteResume(@PathVariable int resumeId,
                                          @PathVariable int applicantId) {
        ResumeDto existing = resumeServiceImpl.getResumeById(resumeId);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        if (existing.getApplicantId() != applicantId) {
            return ResponseEntity.status(403).build();
        }

        if(resumeServiceImpl.deleteResume(resumeId))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/job/{jobId}/resume/{resumeId}")
    public ResponseEntity<Void> respondToJob(@PathVariable int jobId,
                                             @PathVariable int resumeId) {

        if (!jobService.existsById(jobId) || !resumeServiceImpl.existsById(resumeId)) {
            return ResponseEntity.notFound().build();
        }

        resumeServiceImpl.addResponse(jobId, resumeId);

        return ResponseEntity.ok().build();
    }


}
