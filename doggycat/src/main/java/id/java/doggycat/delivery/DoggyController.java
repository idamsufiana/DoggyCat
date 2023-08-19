package id.java.doggycat.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.java.doggycat.model.response.ResponseData;
import id.java.doggycat.service.DoggyService;
import id.java.doggycat.usecase.DoggyUsecase;

@RestController
@RequestMapping("/")
public class DoggyController {

    @Autowired
    private DoggyUsecase doggyUsecase;

    @Autowired
    private DoggyService doggyService;


    @GetMapping("List")
    public ResponseEntity<String> getList(){
        return doggyService.getListDogs();
    }

    //API GET 1

    @GetMapping("SubBreedList/{name}")
    public ResponseEntity<ResponseData<String>> getSubBreedList(@PathVariable("name") String name){
        return doggyUsecase.getSubBreedList(name);
    }
    

    //API GET 2

    @GetMapping("SubBreedImages/{name}")
    public ResponseEntity<ResponseData<String>> getSubBreedImage(@PathVariable("name") String name){
        return doggyUsecase.getSubBreedImage(name);
    }

    //API GET 3

    @GetMapping("OddImages/{name}")
    public ResponseEntity<ResponseData<String>> getOddImages(@PathVariable("name") String name){
        return doggyUsecase.getOddImage(name);
    }

    @PostMapping("SavetoDB")
    public ResponseEntity<ResponseData<String>> postToDB(){
        return doggyUsecase.postList();
    }

    @DeleteMapping("EmptyDB")
    public ResponseEntity<ResponseData<String>> emptyDB(){
        return doggyUsecase.emptyDB();
    }


}
