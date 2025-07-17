package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dto.ImageDto;
import kg.zllloy.jobsearch.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping
    public ResponseEntity<?> getImage(@RequestParam(name = "filename") String filename) {
        return imageService.getById(filename);
    }

    @PostMapping
    public HttpStatus create(@RequestBody ImageDto imageDto) {
        imageService.create(imageDto);
        return HttpStatus.CREATED;
    }
}
