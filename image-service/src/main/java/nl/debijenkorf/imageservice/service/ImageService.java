package nl.debijenkorf.imageservice.service;

public interface ImageService {
    byte[] getImage(String predefinedImageType, String reference) throws InterruptedException;

    void flushImage(String predefinedImageType, String reference);
}
