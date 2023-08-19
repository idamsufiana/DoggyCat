package id.java.doggycat.usecase;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import id.java.doggycat.model.db.Dog;
import id.java.doggycat.model.response.ResponseData;
import id.java.doggycat.model.temp.Doggy;
import id.java.doggycat.model.temp.tempStore;
import id.java.doggycat.repository.DoggyRepository;
import id.java.doggycat.service.DoggyService;
import id.java.doggycat.service.DoggySwitch;
import id.java.doggycat.service.impl.CommonService;
import id.java.doggycat.service.impl.SpecialService;

@Component
public class DoggyUsecase {


    @Autowired
    SpecialService specialUsecase;

    @Autowired
    CommonService commonUsecase;

    @Autowired
    DoggyFactory doggyFactory;

    @Autowired
    DoggyRepository doggyRepository;

    @Autowired
    DoggyService doggyService;


    ResponseEntity<Doggy> response;


    //case Shiba
    public ResponseEntity<ResponseData<String>> getOddImage(String Breed){
        DoggySwitch Switch = doggyFactory.getImages(Breed);
        return Switch.getOddImage(Breed);
    }
    

    //case sheepdog

    public ResponseEntity<ResponseData<String>> getSubBreedList(String Breed){
        DoggySwitch Switch = doggyFactory.getList(Breed);
        return Switch.getSubBreedList(Breed);
    }
    
    // case Terrier

    public ResponseEntity<ResponseData<String>> getSubBreedImage(String Breed){
        DoggySwitch Switch = doggyFactory.getSubBreedImage(Breed);
        return Switch.getSubBreedImage(Breed);
    }


    //post save to db
     public ResponseEntity<ResponseData<String>> postList(){

        ResponseEntity<tempStore> responseDoggy;
        HashMap<String,Object> Hash01 = new HashMap<>();
        ResponseData<String> responseData = new ResponseData<>();
        
        responseDoggy = doggyService.getList();
        Hash01 = responseDoggy.getBody().getMessage();
        
        for(HashMap.Entry m : Hash01.entrySet()){    
            Dog dog = new Dog(0, null, null, null);
            dog.setBreed(m.getKey().toString());
            dog.setSubBreed(m.getValue().toString());
            doggyRepository.save(dog);
           }
           responseData.setPayload(Hash01);
           responseData.setStatus(true);
        return ResponseEntity.ok(responseData);
        
    }

    //del delete from db

    public ResponseEntity<ResponseData<String>> emptyDB(){
        ResponseData<String> responseData = new ResponseData<>();
        doggyRepository.deleteAll();
        responseData.setStatus(true);
        return ResponseEntity.ok(responseData);
        
    }
    
    
}
