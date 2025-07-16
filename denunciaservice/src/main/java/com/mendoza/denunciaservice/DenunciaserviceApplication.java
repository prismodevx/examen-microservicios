package com.mendoza.denunciaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DenunciaserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DenunciaserviceApplication.class, args);
    }

}
