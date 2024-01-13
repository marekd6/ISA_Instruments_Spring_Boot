package pl.edu.pg.eti.id_191684.orchestra.orchestrasection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class OrchestraSectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestraSectionApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().build();
	}

}
