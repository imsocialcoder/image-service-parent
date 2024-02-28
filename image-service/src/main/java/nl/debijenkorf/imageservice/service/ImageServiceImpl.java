package nl.debijenkorf.imageservice.service;

import nl.debijenkorf.imageservice.config.ImageServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{

    private final ImageServiceConfiguration config;

    @Autowired
    public ImageServiceImpl(ImageServiceConfiguration config) {
        this.config = config;
    }
    public byte[] getImage(String predefinedTypeName, String dummySeoName, String reference) {
        return new byte[0];
    }

    public void flushImage(String predefinedImageType, String reference) {

    }
}
