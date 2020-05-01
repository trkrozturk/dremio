package com.dremio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.dremio"})
public class DremioApplication {

    public static void main(String[] args) {
        SpringApplication.run(DremioApplication.class, args);
    }
}
