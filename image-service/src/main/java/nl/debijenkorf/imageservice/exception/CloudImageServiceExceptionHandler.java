package nl.debijenkorf.imageservice.exception;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Profile("!local")
public class CloudImageServiceExceptionHandler {
    @ExceptionHandler(PredefinedImageTypeNotFoundException.class)
    public ResponseEntity<String> handlePredefinedImageTypeNotFound(PredefinedImageTypeNotFoundException e) {
        logExceptionToDB(e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("The requested predefined image type does not exist.");
    }

    @ExceptionHandler(SourceImageNotFoundException.class)
    public ResponseEntity<String> handleSourceImageNotFound(SourceImageNotFoundException e) {
        logExceptionToDB(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The requested source image does not exist.");
    }

    @ExceptionHandler(SourceUrlDownException.class)
    public ResponseEntity<String> handleSourceUrlError(SourceUrlDownException e) {
        logExceptionToDB(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The source URL is down or responds with an error code.");
    }

    @ExceptionHandler(S3WriteException.class)
    public ResponseEntity<String> handleS3WriteException(S3WriteException e) {
        logExceptionToDB(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error writing the image to S3 storage.");
    }

    @ExceptionHandler(S3ConnectionException.class)
    public ResponseEntity<String> handleS3ConnectionException(S3ConnectionException e) {
        logExceptionToDB(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No connection (or access) to S3.");
    }

    private void logExceptionToDB(Exception e){

    }

}
