package nl.debijenkorf.imageservice.exception;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Profile("local")
public class LocalImageServiceExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(LocalImageServiceExceptionHandler.class);

    @ExceptionHandler(PredefinedImageTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handlePredefinedImageTypeNotFound(PredefinedImageTypeNotFoundException e) {
        logger.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The requested predefined image type does not exist.");
    }
}
