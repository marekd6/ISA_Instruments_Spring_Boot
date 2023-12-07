package pl.edu.pg.eti.id_191684.orchestra.orchestragateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

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
                                "/api/sections/{uuid}/instruments/**"
                                //,"/api/instruments/sections/{uuid}"
                        )
                        .uri(instrumentUrl)
                )
                .build();
    }

    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }

}
