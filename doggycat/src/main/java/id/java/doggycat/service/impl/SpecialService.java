package id.java.doggycat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.java.doggycat.model.response.ResponseData;
import id.java.doggycat.model.temp.Doggy;
import id.java.doggycat.service.DoggyService;
import id.java.doggycat.service.DoggySwitch;

@Service
@Configurable
public class SpecialService implements DoggySwitch{

    @Autowired
    private DoggyService doggyService;

    ResponseEntity<Doggy> response;


    //case Shiba
    @Override
    public ResponseEntity<ResponseData<String>> getOddImage(String Breed){

        List<String> image = new ArrayList<>();
        List<String> Result = new ArrayList<>();
        ResponseData<String> responseData = new ResponseData<>();
        ResponseEntity<Doggy> responseImage;
   
        responseImage = doggyService.getBreedImages(Breed);
        image = responseImage.getBody().getMessage();

        for(int i=0; i<image.size(); i++){
            String data = extractNumber(image.get(i));
            if (Integer.parseInt(data) % 2 != 0){
                Result.add(image.get(i));
            }
        }
        
        responseData.setMessages(Result);
        responseData.setStatus(true);
    
        return ResponseEntity.ok(responseData);
    }
    

    //case sheepdog

    @Override
    public ResponseEntity<ResponseData<String>> getSubBreedList(String Breed){

        List<String> DoggyHash = new ArrayList<>();
        List<String> image = new ArrayList<>();
        HashMap<String,Object> Hash01 = new HashMap<>();
        ResponseData<String> responseData = new ResponseData<>();
        response = doggyService.getSubBreedList(Breed);
        int size = response.getBody().getMessage().size();
        for(int i=0; i<size; i++){
            DoggyHash.add(Breed+"-"+response.getBody().getMessage().get(i));
            Hash01.put(DoggyHash.get(i), image);
            }
        responseData.setPayload(Hash01);
        responseData.setStatus(true);
    
        return ResponseEntity.ok(responseData);
    }
    
    // case Terrier

    @Override
    public ResponseEntity<ResponseData<String>> getSubBreedImage(String Breed){

        List<String> DoggyHash = new ArrayList<>();
        List<String> image = new ArrayList<>();
        HashMap<String,Object> images = new HashMap<>();
        ResponseData<String> responseData = new ResponseData<>();
        ResponseEntity<Doggy> responseImage;

        response = doggyService.getSubBreedList(Breed);
        int size = response.getBody().getMessage().size();
        for(int i=0; i<size; i++){
            DoggyHash.add(Breed+"-"+response.getBody().getMessage().get(i));
            responseImage = doggyService.getSubBreedImages(Breed, response.getBody().getMessage().get(i));
            image = responseImage.getBody().getMessage();
            images.put(DoggyHash.get(i), image);
            }
        
        responseData.setPayload(images);
        responseData.setStatus(true);
    
        return ResponseEntity.ok(responseData);
    }

    public static String extractNumber(final String str) {                
    
        if(str == null || str.isEmpty()) return "";
        
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
                found = true;
            } else if(found){
                break;                
            }
        }
        
        return sb.toString();
    }
    
    
}
