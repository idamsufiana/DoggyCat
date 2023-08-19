package id.java.doggycat.service;

import org.springframework.http.ResponseEntity;

import id.java.doggycat.model.response.ResponseData;

public interface DoggySwitch {

    ResponseEntity<ResponseData<String>> getOddImage(String Breed);
    ResponseEntity<ResponseData<String>> getSubBreedList(String Breed);
    ResponseEntity<ResponseData<String>> getSubBreedImage(String Breed);

    
}
