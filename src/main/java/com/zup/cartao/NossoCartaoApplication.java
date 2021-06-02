package com.zup.cartao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NossoCartaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NossoCartaoApplication.class, args);
	}

}
