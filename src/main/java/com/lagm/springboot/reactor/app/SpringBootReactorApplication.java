package com.lagm.springboot.reactor.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootReactorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Creación de un Flux (Publisher o Observable)
		Flux<String> nombres = Flux.just("Andres", "Pedro", "Diego", "Juan")
				.doOnNext(elemento -> System.out.println(elemento));
		nombres.subscribe(); // Para suscribirse al flujo
		
		Flux<String> nombres2 = Flux.just("Andres", "Pedro", "Diego", "Juan")
				.doOnNext(System.out::println);
		nombres2.subscribe();
		
	}

}
