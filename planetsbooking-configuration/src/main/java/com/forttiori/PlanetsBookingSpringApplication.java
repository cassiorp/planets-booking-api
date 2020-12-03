package com.forttiori;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PlanetsBookingSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanetsBookingSpringApplication.class, args);
    }

}
