package nl.debijenkorf.imageservice.controller;

import nl.debijenkorf.imageservice.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/show/{predefinedImageType}/{dummySeoName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public ResponseEntity<byte[]> getImage(
            @PathVariable String predefinedImageType,
            @PathVariable(required = false) String dummySeoName,
            @RequestParam String reference
    ) throws InterruptedException {
        if (!isValidPredefinedType(predefinedImageType)) {
            return ResponseEntity.notFound().build();
        }

        if (!isValidReference(reference)) {
            return ResponseEntity.notFound().build();
        }

        byte[] imageData = imageService.getImage(predefinedImageType, reference);
        return ResponseEntity.ok(imageData);
    }

    @DeleteMapping("/flush/{predefinedImageType}")
    @ResponseBody
    public ResponseEntity<String> flushImage(
            @PathVariable String predefinedImageType,
            @RequestParam String reference
    ) {
        if (!isValidPredefinedType(predefinedImageType)) {
            return ResponseEntity.notFound().build();
        }

        imageService.flushImage(predefinedImageType, reference);
        return ResponseEntity.ok("Image flushed successfully");
    }

    private boolean isValidPredefinedType(String predefinedTypeName) {
        return StringUtils.hasText(predefinedTypeName);
    }

    private boolean isValidReference(String reference) {
        return StringUtils.hasText(reference);
    }}

