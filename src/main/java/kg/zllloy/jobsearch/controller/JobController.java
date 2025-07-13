package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.JobDto;
import kg.zllloy.jobsearch.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @GetMapping
    public List<JobDto> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<JobDto> getJob(@PathVariable int jobId) {
        return new ResponseEntity<>(jobService.getJobById(jobId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addJob(JobDto jobDto) {
        jobService.addJob(jobDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editJob(@PathVariable String id, @RequestBody JobDto jobDto) {
        jobService.editJob(jobDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable int id) {
        if(jobService.deleteJob(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }


}
