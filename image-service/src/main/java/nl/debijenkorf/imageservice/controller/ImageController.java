package nl.debijenkorf.imageservice.controller;

import nl.debijenkorf.imageservice.response.FlushResponse;
import nl.debijenkorf.imageservice.response.ImageResponse;
import nl.debijenkorf.imageservice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ImageResponse showImage(
            @PathVariable String predefinedTypeName,
            @PathVariable(required = false) String dummySeoName,
            @RequestParam String reference
    ) {
        byte[] imageData = imageService.getImage(predefinedTypeName, dummySeoName, reference);
        return new ImageResponse(imageData, HttpStatus.OK.value());
    }

    @DeleteMapping("/flush/{predefinedImageType}")
    @ResponseBody
    public FlushResponse flushImage(
            @PathVariable String predefinedImageType,
            @RequestParam String reference
    ) {
        imageService.flushImage(predefinedImageType, reference);
        return new FlushResponse("Image flushed successfully", HttpStatus.OK.value());
    }

    @GetMapping(value = "/")
    @ResponseBody
    public void show() {
        imageService.getImage("", "", "");
//        byte[] imageData = imageService.getImage(predefinedTypeName, dummySeoName, reference);
//        return new ImageResponse(imageData, HttpStatus.OK.value());
    }
}

