package com.tripkit.lighthouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TripkitApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripkitApplication.class, args);
    }

}
