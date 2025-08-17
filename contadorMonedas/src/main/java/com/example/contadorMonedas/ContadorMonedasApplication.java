package com.example.contadorMonedas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContadorMonedasApplication {

	public static void main(String[] args) {SpringApplication.run(ContadorMonedasApplication.class, args);

		Principal principal = new Principal();
		principal.mostrarMenu();

	

}
