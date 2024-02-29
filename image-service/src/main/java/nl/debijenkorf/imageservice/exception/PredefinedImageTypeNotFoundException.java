package nl.debijenkorf.imageservice.exception;

public class PredefinedImageTypeNotFoundException extends RuntimeException {
    public PredefinedImageTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
