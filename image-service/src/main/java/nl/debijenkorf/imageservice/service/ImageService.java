package nl.debijenkorf.imageservice.service;

public interface ImageService {
    byte[] getImage(String predefinedTypeName, String reference);
    void flushImage(String predefinedImageType, String reference);
}

