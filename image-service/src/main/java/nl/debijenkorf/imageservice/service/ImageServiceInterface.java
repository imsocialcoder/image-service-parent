package nl.debijenkorf.imageservice.service;

public interface ImageServiceInterface {
    byte[] getImage(String predefinedImageType, String reference) throws InterruptedException;

    void flushImage(String predefinedImageType, String reference);
}
