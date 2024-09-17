package com.apibookingapp;

import org.springframework.boot.SpringApplication;

public class TestApiBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(ApiBookingAppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
