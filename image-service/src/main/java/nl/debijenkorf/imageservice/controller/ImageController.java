package nl.debijenkorf.imageservice.controller;

import nl.debijenkorf.imageservice.response.FlushResponse;
import nl.debijenkorf.imageservice.response.ImageResponse;
import nl.debijenkorf.imageservice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/show/{predefinedTypeName}/{dummySeoName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public ResponseEntity<ImageResponse> showImage(
            @PathVariable String predefinedTypeName,
            @PathVariable(required = false) String dummySeoName,
            @RequestParam String reference
    ) {
        if (!isValidPredefinedType(predefinedTypeName)) {
            return ResponseEntity.notFound().build();
        }

        if (!isValidReference(reference)) {
            return ResponseEntity.notFound().build();
        }

        byte[] imageData = imageService.getImage(predefinedTypeName, dummySeoName, reference);
        return ResponseEntity.ok(new ImageResponse(imageData));
    }

    @DeleteMapping("/flush/{predefinedImageType}")
    @ResponseBody
    public ResponseEntity<FlushResponse> flushImage(
            @PathVariable String predefinedImageType,
            @RequestParam String reference
    ) {
        if (!isValidPredefinedType(predefinedImageType)) {
            return ResponseEntity.notFound().build();
        }

        imageService.flushImage(predefinedImageType, reference);
        return ResponseEntity.ok(new FlushResponse("Image flushed successfully"));
    }

    private boolean isValidPredefinedType(String predefinedTypeName) {
        return predefinedTypeName != null && !predefinedTypeName.isEmpty();
    }

    private boolean isValidReference(String reference) {
        return reference != null && !reference.isEmpty();
    }
}

