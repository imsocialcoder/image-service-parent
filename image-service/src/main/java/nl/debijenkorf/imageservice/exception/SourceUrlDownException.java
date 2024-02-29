package nl.debijenkorf.imageservice.exception;

public class SourceUrlDownException extends RuntimeException {
    public SourceUrlDownException(String message, Throwable cause) {
        super(message, cause);
    }
}
