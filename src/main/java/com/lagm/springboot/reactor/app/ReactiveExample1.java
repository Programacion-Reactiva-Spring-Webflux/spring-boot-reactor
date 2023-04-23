package com.lagm.springboot.reactor.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import reactor.core.publisher.Flux;

public class ReactiveExample1 implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(ReactiveExample1.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Flujo de letras");
		Flux.just("A", "B", "C")
			.subscribe(System.out::println);
		
		System.out.println("Flujo de minúsculas");
		Flux.just("A", "B", "C")
			.map(String::toLowerCase) // map(item -> item.toLowerCase())
			.subscribe(System.out::println);
		
		System.out.println("Rango 1-5");
		Flux.range(1, 5)
			.subscribe(System.out::println);
		
		System.out.println("Rango 1-10 impares");
		Flux.range(1, 10)
			.filter(item -> item % 2 != 0)
			.subscribe(System.out::println);
		
		System.out.println("Rango 1-10 pares");
		Flux.range(1, 10)
			.filter(item -> item % 2 == 0)
			.doOnNext(System.out::println)
			.subscribe();
		
		System.out.println("Listado de frutas");
		// Lista de frutas a sus longitudes
		Flux.just("apple", "banana", "orange")
			.map(fruta -> fruta + " " + (fruta.length()))
			.subscribe(System.out::println);
		
		System.out.println("Listado de nombres");
		// Listado de nombres a longitudes
		List<String> nombres = Arrays.asList("Luis", "Alberto", "Guisado", "Mena");
		Flux.fromIterable(nombres)
			.map(nombre -> nombre + ": " + nombre.length())
			.subscribe(System.out::println);
	}

}
