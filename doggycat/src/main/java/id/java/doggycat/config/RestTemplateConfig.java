package id.java.doggycat.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import id.java.doggycat.properties.AppProperties;

@Configuration
public class RestTemplateConfig{

    @Autowired
    private AppProperties appProperties;

    @Bean("restTemplate")
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(appProperties.getHTTP_CLIENT_TIMEOUT());
        requestFactory.setReadTimeout(appProperties.getHTTP_CLIENT_TIMEOUT());
        return new RestTemplate(requestFactory);
    }
    
}
