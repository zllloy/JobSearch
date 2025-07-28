package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.VacancyDto;
import kg.zllloy.jobsearch.dto.ResumeDto;
import kg.zllloy.jobsearch.service.impl.ResumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {
    private final ResumeServiceImpl resumeServiceImpl;


    @GetMapping
    public List<VacancyDto> getAllResumes() {
        return resumeServiceImpl.getAllResumes();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ResumeDto>> getResumeByCategory(@PathVariable int id) {
        List<ResumeDto> resumes = resumeServiceImpl.getResumesByCategory(id);
        return ResponseEntity.ok(resumes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResumeDto> getResumeById(@PathVariable int id) {
        ResumeDto resume = resumeServiceImpl.getResumeById(id);
        return ResponseEntity.ok(resume);
    }

    @PostMapping("/create/{applicantId}")
    public ResponseEntity<Void> createResume(@PathVariable int applicantId, @RequestBody ResumeDto resumeDto) {
//        ApplicantDto applicant = applicantService.getApplicantById(applicantId);
//        if (applicant == null) {
//            return ResponseEntity.notFound().build();
//        }

        resumeServiceImpl.addResume(applicantId, resumeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<List<ResumeDto>> getApplicantById(@PathVariable int applicantId) {
        List<ResumeDto> resumesByApplicant = resumeServiceImpl.getResumesByApplicant(applicantId);
        if (resumesByApplicant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resumesByApplicant);
    }

    @PutMapping("/edit/{resumeId}/applicant/{applicantId}")
    public ResponseEntity<Void> editResume(@PathVariable int resumeId,
                                           @PathVariable int applicantId,
                                           @RequestBody ResumeDto resumeDto) throws AccessDeniedException {
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

    @DeleteMapping("/{resumeId}/applicant/{applicantId}")
    public ResponseEntity<Void> deleteResume(
            @PathVariable int resumeId,
            @PathVariable int applicantId) {

        resumeServiceImpl.deleteResume(resumeId, applicantId);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/vacancy/{vacancyId}/resume/{resumeId}")
//    public ResponseEntity<Void> respondToVacancy(@PathVariable int vacancyId,
//                                             @PathVariable int resumeId) {
////
////        if (!jobService.existsById(vacancyId) || !resumeServiceImpl.existsById(resumeId)) {
////            return ResponseEntity.notFound().build();
////        }
//
//        resumeServiceImpl.addResponse(vacancyId, resumeId);
//
//        return ResponseEntity.ok().build();
//    }


}
