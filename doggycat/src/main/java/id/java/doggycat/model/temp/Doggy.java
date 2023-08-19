package id.java.doggycat.model.temp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Doggy {

        @JsonProperty("message")
        private List<String> message;

        @JsonProperty("status")
        private String status;


    
}
