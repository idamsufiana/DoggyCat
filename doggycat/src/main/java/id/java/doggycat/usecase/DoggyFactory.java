package id.java.doggycat.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.java.doggycat.properties.AppProperties;
import id.java.doggycat.service.DoggySwitch;
import id.java.doggycat.service.impl.CommonService;
import id.java.doggycat.service.impl.SpecialService;


@Component
public class DoggyFactory {

    @Autowired
    AppProperties appProperties;

    @Autowired
    SpecialService specialService;

    @Autowired
    CommonService commonService;


    public DoggySwitch getImages(String Doggy){

        if(Doggy.equalsIgnoreCase(appProperties.getShiba())){
            return specialService;
        }else{
            return commonService;
        }

    }
    
    public DoggySwitch getList(String Doggy){

        if(Doggy.equalsIgnoreCase(appProperties.getSheepdog())){
            return specialService;
        }else{
            return commonService;
        }

    }

    public DoggySwitch getSubBreedImage(String Doggy){

        if(Doggy.equalsIgnoreCase(appProperties.getTerrier())){
            
            return specialService;
        }else{
            return commonService;
        }

    }
    
}
