package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.VacancyDto;
import kg.zllloy.jobsearch.service.ResponseService;
import kg.zllloy.jobsearch.service.impl.ResumeServiceImpl;
import kg.zllloy.jobsearch.service.impl.VacancyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vacancies")
public class VacancyController {
    private final VacancyServiceImpl vacancyService;
    private final ResponseService responseService;
    private final ResumeServiceImpl resumeServiceImpl;
    private final VacancyServiceImpl vacancyServiceImpl;

    @GetMapping
    public List<VacancyDto> getAllVacancies() {
       return vacancyServiceImpl.getAllVacancies();
    }

    @GetMapping("/{vacancyId}")
    public ResponseEntity<VacancyDto> getVacancy(@PathVariable int vacancyId) {
        return null;
    }

    @GetMapping("/category/{categoryId}")
    public List<VacancyDto> getVacanciesByCategory(@PathVariable int categoryId) {
        return vacancyServiceImpl.getVacanciesByCategory(categoryId);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addVacancy(VacancyDto vacancyDto) {
        return null;
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editVacancy(@PathVariable String id, @RequestBody VacancyDto vacancyDto) {
       return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVacancy(@PathVariable int id) {
        return null;
    }

    @PostMapping("/{jobId}/resume/{resumeId}")
    public ResponseEntity<Void> respondToVacancy(@PathVariable int jobId,
                                             @PathVariable int resumeId) {

//        if (!vacancyService.existsById(jobId) || !resumeServiceImpl.existsById(resumeId)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        if (responseService.existsByJobAndResume(jobId, resumeId)) {
//            return ResponseEntity.status(409).build();
//        }
//
//        responseService.createResponse(jobId, resumeId);
//        return ResponseEntity.status(201).build();

        return null;
    }


}
