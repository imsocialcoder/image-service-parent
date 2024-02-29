package nl.debijenkorf.imageservice.service;

import nl.debijenkorf.imageservice.exception.PredefinedImageTypeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AWSS3Service {

    public byte[] getOptimizedImageFromStorage(String predefinedImageType, String reference) {
        if(!isPredefinedTypeExists(predefinedImageType))
            throw new PredefinedImageTypeNotFoundException(predefinedImageType);
        return null;
    }


    private boolean isPredefinedTypeExists(String predefinedImageType){
        return false;
    }

    public void saveImage(byte[] optimizedImage){

    }

    public void flushImage(String predefinedImageType, String reference) {
        if(predefinedImageType.toLowerCase().equals("original")){
            flushAll();
        }else{
            flushImageByTypeAndReference(predefinedImageType, reference);
        }
    }

    private void flushAll(){

    }

    private void flushImageByTypeAndReference(String predefinedImageType, String reference){

    }

    public byte[] getOriginalImageFromStorage(String reference) {
        return null;
    }
}
