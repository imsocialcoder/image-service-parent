package nl.debijenkorf.imageservice.response;

public class ImageResponse {

    private byte[] imageData;

    public ImageResponse(byte[] imageData) {
        this.imageData = imageData;
    }

    public byte[] getImageData() {
        return imageData;
    }

}

