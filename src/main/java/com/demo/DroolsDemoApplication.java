package com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.demo.model.Fare;
import com.demo.model.TaxiRide;
import com.demo.service.FareCalculationService;

@SpringBootApplication
public class DroolsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolsDemoApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	FareCalculationService taxiFareCalculatorService = (FareCalculationService) ctx.getBean(FareCalculationService.class);
            TaxiRide taxiRide = new TaxiRide();
            taxiRide.setIsNightSurcharge(true);
            taxiRide.setDistanceInMile(190L);
            Fare rideFare = new Fare();
            taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
        };
    }
}
