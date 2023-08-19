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
public class CommonService implements DoggySwitch{

    @Autowired
    private DoggyService doggyService;

    ResponseEntity<Doggy> response;


    //get Normal image
    @Override
    public ResponseEntity<ResponseData<String>> getOddImage(String Breed){

        List<String> image = new ArrayList<>();
        ResponseData<String> responseData = new ResponseData<>();
        ResponseEntity<Doggy> responseImage;
   
        responseImage = doggyService.getBreedImages(Breed);
        image = responseImage.getBody().getMessage();
        
        responseData.setMessages(image);
        responseData.setStatus(true);
    
        return ResponseEntity.ok(responseData);
    }
    

    //get normal list
    @Override
    public ResponseEntity<ResponseData<String>> getSubBreedList(String Breed){


        HashMap<String,Object> Hash01 = new HashMap<>();
        ResponseData<String> responseData = new ResponseData<>();
        response = doggyService.getSubBreedList(Breed);
        int size = response.getBody().getMessage().size();
        for(int i=0; i<size; i++){
            Hash01.put(response.getBody().getMessage().get(i),"");
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

        response = doggyService.getSubBreedList(Breed);
        int size = response.getBody().getMessage().size();
        for(int i=0; i<size; i++){
            DoggyHash.add(response.getBody().getMessage().get(i));
            images.put(DoggyHash.get(i), image);
            }
        
        responseData.setPayload(images);
        responseData.setStatus(true);
    
        return ResponseEntity.ok(responseData);
    }
    
}
