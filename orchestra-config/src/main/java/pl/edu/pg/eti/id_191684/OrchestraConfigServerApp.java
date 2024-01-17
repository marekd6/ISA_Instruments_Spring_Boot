package pl.edu.pg.eti.id_191684;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class OrchestraConfigServerApp {

    public static void main(String[] args) {
        SpringApplication.run(OrchestraConfigServerApp.class, args);
    }


}