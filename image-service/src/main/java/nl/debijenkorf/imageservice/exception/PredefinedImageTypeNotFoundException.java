package nl.debijenkorf.imageservice.exception;

public class PredefinedImageTypeNotFoundException extends RuntimeException {
    private final String predefinedTypeName;

    public PredefinedImageTypeNotFoundException(String predefinedTypeName) {
        super("The requested predefined image type does not exist: " + predefinedTypeName);
        this.predefinedTypeName = predefinedTypeName;
    }
}
