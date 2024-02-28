package nl.debijenkorf.imageservice.response;

public class FlushResponse {

    private String message;
    private int statusCode;

    public FlushResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}

