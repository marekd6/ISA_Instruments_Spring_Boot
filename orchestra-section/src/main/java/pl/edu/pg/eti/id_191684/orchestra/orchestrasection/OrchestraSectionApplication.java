package pl.edu.pg.eti.id_191684.orchestra.orchestrasection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrchestraSectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestraSectionApplication.class, args);
	}

	/**
	 * @param baseUrl base URL
	 * @return configured endpoint for section module
	 */
	@Bean
	public RestTemplate restTemplate(@Value("${orchestra.instrument.url}") String baseUrl) {
		return new RestTemplateBuilder().rootUri(baseUrl).build();
	}

}
