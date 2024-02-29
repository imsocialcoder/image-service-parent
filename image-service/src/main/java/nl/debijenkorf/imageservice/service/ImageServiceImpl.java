package nl.debijenkorf.imageservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{

    private final AWSS3Service awss3Service;

    @Autowired
    public ImageServiceImpl(AWSS3Service awss3Service) {
        this.awss3Service = awss3Service;
    }
    public byte[] getImage(String predefinedTypeName, String reference) {
        //return optimized image from storage:
        byte[] imageFromStorage = awss3Service.getOptimizedImageFromStorage(predefinedTypeName, reference);
        if(imageFromStorage != null){
            return imageFromStorage;
        }

        //Optimize original image and save it if exists in the storage
        //Call the method again
        if (isOriginalImageExistsOptimizeIt(reference)) return getImage(predefinedTypeName, reference);

        //Download the original image and save the original one
        byte[] downloadedOriginalImage = downloadImage(predefinedTypeName, reference);
        awss3Service.saveImage(downloadedOriginalImage);

        //Optimize original image and save it if exists in the storage
        //Call the method again
        if (isOriginalImageExistsOptimizeIt(reference)) return getImage(predefinedTypeName, reference);

        return new byte[0];
    }

    private boolean isOriginalImageExistsOptimizeIt(String reference) {
        byte[] originalImageFromStorage = awss3Service.getOriginalImageFromStorage(reference);
        if(originalImageFromStorage != null){
            optimizeAndSaveImage(originalImageFromStorage);
            return true;
        }
        return false;
    }

    private void optimizeAndSaveImage(byte[] originalImageFromStorage) {
        byte[] optimizedImage = optimizeImage(originalImageFromStorage);
        awss3Service.saveImage(optimizedImage);
    }

    public void flushImage(String predefinedImageType, String reference) {
        awss3Service.flushImage(predefinedImageType, reference);
    }

    private byte[] optimizeImage(byte[] originalImage){
        return null;
    }

    private byte[] downloadImage(String predefinedTypeName, String reference){
        return null;
    }


}
