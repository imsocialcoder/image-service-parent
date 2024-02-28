package nl.debijenkorf.imageservice.service;

import org.springframework.stereotype.Service;

@Service
public class ImageService {

    public byte[] getImage(String predefinedTypeName, String dummySeoName, String reference) {
        return new byte[0];
    }

    public void flushImage(String predefinedImageType, String reference) {

    }
}

