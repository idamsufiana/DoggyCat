package id.java.doggycat.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties("app")
public class AppProperties {

    int HTTP_CLIENT_TIMEOUT = 1000000;
    String url = "https://dog.ceo/api/breeds/list/all";
    String BreedUrl = "https://dog.ceo/api/breed/";
    String sheepdog = "sheepdog";
    String terrier = "terrier";
    String shiba = "shiba";
    String list = "/list";
    String images = "/images";    
    
}
