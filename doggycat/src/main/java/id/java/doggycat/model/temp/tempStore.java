package id.java.doggycat.model.temp;

import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class tempStore {


        @JsonProperty("message")
        private HashMap<String, Object> message = new HashMap<>();

        @JsonProperty("status")
        private String status;


    
}
