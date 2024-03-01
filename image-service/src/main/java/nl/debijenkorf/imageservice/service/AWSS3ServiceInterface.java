package nl.debijenkorf.imageservice.service;

public interface AWSS3ServiceInterface {

    byte[] getOptimizedImageFromStorage(String predefinedImageType, String reference);

    void saveImage(String predefinedImageType, String reference, byte[] optimizedImage) throws InterruptedException;

    void flushImage(String predefinedImageType, String reference);

    byte[] getOriginalImageFromStorage(String reference);
}
