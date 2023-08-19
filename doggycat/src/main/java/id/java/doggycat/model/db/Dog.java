package id.java.doggycat.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Breed;
    private String subBreed;
    private String Images;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBreed() {
        return Breed;
    }
    public void setBreed(String breed) {
        Breed = breed;
    }
    public String getSubBreed() {
        return subBreed;
    }
    public void setSubBreed(String subBreed) {
        this.subBreed = subBreed;
    }
    public String getImages() {
        return Images;
    }
    public void setImages(String images) {
        Images = images;
    }
    public Dog(int id, String breed, String subBreed, String images) {
        this.id = id;
        Breed = breed;
        this.subBreed = subBreed;
        Images = images;
    }
  
    
}
