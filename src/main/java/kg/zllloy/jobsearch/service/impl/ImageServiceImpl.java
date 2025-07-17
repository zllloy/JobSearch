package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dto.ImageDto;
import kg.zllloy.jobsearch.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Override
    public ResponseEntity<?> create(ImageDto imageDto) {
        String filename = saveUploadedFile(imageDto.getFile(), "images");
        System.out.println(filename);
        return null;
    }

    @Override
    public ResponseEntity<?> getById(String filename) {
        return downloadFile(filename, "images", MediaType.IMAGE_JPEG);
    }
}
