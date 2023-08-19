package id.java.doggycat.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import id.java.doggycat.model.temp.Doggy;
import id.java.doggycat.model.temp.tempStore;
import id.java.doggycat.properties.AppProperties;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DoggyService {

    @Autowired
    AppProperties appProperties;

    @Autowired
    private RestTemplate template = new RestTemplate();

    final Map<String, RestTemplate> mapRestTemplate = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

    public ResponseEntity<String> getListDogs(){
    ResponseEntity<String> response = template.exchange(appProperties.getUrl(), HttpMethod.GET, requestEntity, String.class);
    return response;
    }

    public ResponseEntity<tempStore> getList(){
    ResponseEntity<tempStore> response = template.exchange(appProperties.getUrl(), HttpMethod.GET, requestEntity, tempStore.class);
    return response;
    }

    public ResponseEntity<Doggy> getSubBreedList(String Breed){
    ResponseEntity<Doggy> response = template.exchange(appProperties.getBreedUrl()+Breed+appProperties.getList(), HttpMethod.GET, requestEntity, Doggy.class);
    return response;

    }

    public ResponseEntity<Doggy> getBreedImages(String Breed){
    ResponseEntity<Doggy> response = template.exchange(appProperties.getBreedUrl()+Breed+appProperties.getImages(), HttpMethod.GET, requestEntity, Doggy.class);
    return response;

    }

    public ResponseEntity<Doggy> getSubBreedImages(String Breed, String subBreed){
    ResponseEntity<Doggy> response = template.exchange(appProperties.getBreedUrl()+Breed+"/"+subBreed+appProperties.getImages(), HttpMethod.GET, requestEntity, Doggy.class);
    return response;

    }
}
