package nl.debijenkorf.imageservice.response;

public class ImageResponse {

    private byte[] imageData;
    private int statusCode;

    public ImageResponse(byte[] imageData, int statusCode) {
        this.imageData = imageData;
        this.statusCode = statusCode;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public int getStatusCode() {
        return statusCode;
    }
}

