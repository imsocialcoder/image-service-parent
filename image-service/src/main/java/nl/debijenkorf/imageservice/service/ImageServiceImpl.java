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
    public byte[] getImage(String predefinedTypeName, String reference) {
        //return optimized image from storage:
        byte[] imageFromStorage = getOptimizedImageFromStorage(predefinedTypeName, reference);
        if(imageFromStorage != null){
            return imageFromStorage;
        }

        //Optimize original image and save it if exists in the storage
        //Call the method again
        if (isOriginalImageExistsOptimizeIt(reference)) return getImage(predefinedTypeName, reference);

        //Download the original image and save the original one
        byte[] downloadedOriginalImage = downloadImage(predefinedTypeName, reference);
        saveImage(downloadedOriginalImage);

        //Optimize original image and save it if exists in the storage
        //Call the method again
        if (isOriginalImageExistsOptimizeIt(reference)) return getImage(predefinedTypeName, reference);

        return new byte[0];
    }

    private boolean isOriginalImageExistsOptimizeIt(String reference) {
        byte[] originalImageFromStorage = getOriginalImageFromStorage(reference);
        if(originalImageFromStorage != null){
            optimizeAndSaveImage(originalImageFromStorage);
            return true;
        }
        return false;
    }

    private void optimizeAndSaveImage(byte[] originalImageFromStorage) {
        byte[] optimizedImage = optimizeImage(originalImageFromStorage);
        saveImage(optimizedImage);
    }

    public void flushImage(String predefinedImageType, String reference) {
        if(predefinedImageType.toLowerCase().equals("original")){
            flushAll();
        }else{
            flushImageByReference(predefinedImageType, reference);
        }
    }

    private byte[] getOptimizedImageFromStorage(String predefinedTypeName, String reference) {
        return null;
    }

    private byte[] getOriginalImageFromStorage(String reference) {
        return null;
    }

    private byte[] optimizeImage(byte[] originalImage){
        return null;
    }

    private void saveImage(byte[] optimizedImage){

    }

    private byte[] downloadImage(String predefinedTypeName, String reference){
        return null;
    }

    private void flushAll(){

    }

    private void flushImageByReference(String predefinedImageType, String reference){

    }
}
