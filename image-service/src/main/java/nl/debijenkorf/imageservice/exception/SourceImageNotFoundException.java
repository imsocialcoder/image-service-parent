package nl.debijenkorf.imageservice.exception;

public class SourceImageNotFoundException extends RuntimeException {
    public SourceImageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

