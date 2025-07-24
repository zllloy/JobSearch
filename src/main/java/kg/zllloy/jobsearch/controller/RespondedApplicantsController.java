package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.RespondedApplicantsDto;
import kg.zllloy.jobsearch.dto.ResumeDto;
import kg.zllloy.jobsearch.service.impl.RespondedApplicantsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/respondedApplicant")
@RequiredArgsConstructor
public class RespondedApplicantsController {
    private final RespondedApplicantsServiceImpl respondedApplicantsServerImpl;

    @GetMapping("/vacancies/{id}")
    public ResponseEntity<List<RespondedApplicantsDto>> getVacanciesByApplicant(@PathVariable int id) {
        List<RespondedApplicantsDto> resumes = respondedApplicantsServerImpl.getVacanciesByApplicant(id);
        if (resumes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resumes);
    }

    @GetMapping("/vacancy/{vacancyId}")
    public ResponseEntity<List<RespondedApplicantsDto>> getRespondedApplicantsByVacancy(@PathVariable int vacancyId) {
        List<RespondedApplicantsDto> applicants = respondedApplicantsServerImpl.getRespondedApplicantsByVacancyId(vacancyId);
        return ResponseEntity.ok(applicants);
    }
}
