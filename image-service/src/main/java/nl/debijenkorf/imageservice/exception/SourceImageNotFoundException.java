package nl.debijenkorf.imageservice.exception;

public class SourceImageNotFoundException extends RuntimeException {
    private final String reference;
    public SourceImageNotFoundException(String reference) {
        super("The requested image does not exist on url, reference: " + reference);
        this.reference = reference;
    }
}

