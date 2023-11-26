package pl.edu.pg.eti.id_191684.orchestra.orchestragateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrchestraGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrchestraGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${orchestra.instrument.url}") String instrumentUrl,
            @Value("${orchestra.section.url}") String sectionUrl,
            @Value("${orchestra.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("sections", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/sections/{uuid}",
                                "/api/sections"
                        )
                        .uri(sectionUrl)
                )
                .route("instruments", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/instruments",
                                "/api/instruments/**",
                                "/api/sections/{uuid}/instruments",
                                "/api/sections/{uuid}/instruments/**",
                                "/api/instruments/sections/{uuid}"//new
                        )
                        .uri(instrumentUrl)
                )
                .build();
    }

}
