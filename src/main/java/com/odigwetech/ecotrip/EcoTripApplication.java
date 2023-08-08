//package com.odigwetech.ecotrip;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@SpringBootApplication
//@RestController
//public class EcoTripApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(EcoTripApplication.class, args);
//	}
//	@GetMapping
//	public List<String> hello(){
//		return List.of("Hello","World");
//	}
//
//}

package com.odigwetech.ecotrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcoTripApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcoTripApplication.class, args);
	}

}
