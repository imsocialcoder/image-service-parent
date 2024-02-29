package nl.debijenkorf.imageservice.exception;

public class S3WriteException extends RuntimeException {
    public S3WriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
