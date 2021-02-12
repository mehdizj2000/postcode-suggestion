package au.com.jaycar.postcode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class PostcodeSuggestionApplication {

    @Value("${suggestion.postcodes.result.page.size:5}")
    private Integer pageSize;

    public static void main(String[] args) {
	SpringApplication.run(PostcodeSuggestionApplication.class, args);
    }

    @Bean
    public Pageable pageable() {
	return PageRequest.of(0, pageSize);
    }

}
