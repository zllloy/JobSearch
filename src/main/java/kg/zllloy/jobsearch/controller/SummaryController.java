package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.SummaryDto;
import kg.zllloy.jobsearch.service.SummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/summary")
public class SummaryController {
    private final SummaryService summaryService;

    @GetMapping
    public List<SummaryDto> getAllSummary() {
        return summaryService.getAllSummary();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<SummaryDto>> getSummaryByCategory(@PathVariable int id) {
        List<SummaryDto> summaries = (List<SummaryDto>) summaryService.getSummaryByCategory(id);
        if (summaries.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(summaries);
    }


}
