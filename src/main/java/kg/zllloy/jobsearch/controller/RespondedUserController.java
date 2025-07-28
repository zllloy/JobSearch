package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.RespondedUserDto;
import kg.zllloy.jobsearch.service.impl.RespondedUserServiceImpl;
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
public class RespondedUserController {
    private final RespondedUserServiceImpl respondedApplicantsServerImpl;

    @GetMapping("/vacancies/{id}")
    public ResponseEntity<List<RespondedUserDto>> getVacanciesByApplicant(@PathVariable int id) {
        List<RespondedUserDto> resumes = respondedApplicantsServerImpl.getVacanciesByApplicant(id);
        if (resumes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resumes);
    }

    @GetMapping("/vacancy/{vacancyId}")
    public ResponseEntity<List<RespondedUserDto>> getRespondedApplicantsByVacancy(@PathVariable int vacancyId) {
        List<RespondedUserDto> applicants = respondedApplicantsServerImpl.getRespondedApplicantsByVacancyId(vacancyId);
        return ResponseEntity.ok(applicants);
    }
}
