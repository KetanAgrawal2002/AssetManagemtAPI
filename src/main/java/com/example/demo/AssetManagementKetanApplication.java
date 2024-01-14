package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class AssetManagementKetanApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetManagementKetanApplication.class, args);
	}

}
