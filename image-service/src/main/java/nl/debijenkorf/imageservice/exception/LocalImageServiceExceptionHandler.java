package nl.debijenkorf.imageservice.exception;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Profile("local")
public class LocalImageServiceExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(LocalImageServiceExceptionHandler.class);

    @ExceptionHandler(PredefinedImageTypeNotFoundException.class)
    public ResponseEntity<String> handlePredefinedImageTypeNotFound(PredefinedImageTypeNotFoundException e) {
        logger.info(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("The requested predefined image type does not exist.");
    }

    @ExceptionHandler(SourceImageNotFoundException.class)
    public ResponseEntity<String> handleSourceImageNotFound(SourceImageNotFoundException e) {
        logger.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The requested source image does not exist.");
    }

    @ExceptionHandler(SourceUrlDownException.class)
    public ResponseEntity<String> handleSourceUrlError(SourceUrlDownException e) {
        logger.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The source URL is down or responds with an error code.");
    }

    @ExceptionHandler(S3WriteException.class)
    public ResponseEntity<String> handleS3WriteException(S3WriteException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error writing the image to S3 storage.");
    }

    @ExceptionHandler(S3ConnectionException.class)
    public ResponseEntity<String> handleS3ConnectionException(S3ConnectionException e) {
        logger.error("There is no connection (or access) to S3.", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No connection (or access) to S3.");
    }

}
