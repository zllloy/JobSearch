package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.EmployerDto;
import kg.zllloy.jobsearch.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employers")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;

    @GetMapping("/{employerId}")
    public ResponseEntity<EmployerDto> getEmployerById(@PathVariable int employerId) {
        EmployerDto employer = employerService.getEmployerById(employerId);
        if (employer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employer);
    }
}
