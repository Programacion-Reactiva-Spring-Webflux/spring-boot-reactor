package com.lagm.springboot.reactor.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import reactor.core.publisher.Flux;

public class ReactiveExample2 implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(ReactiveExample2.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("Lista de números enteros");
		listaNumeros.forEach(System.out::println);
		
		Integer[] arrayNumeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("Array de números enteros");
		Arrays.stream(arrayNumeros).forEach(System.out::println);
		
		
		System.out.println("Cuadrados de los números pares del listado");
		Flux.fromIterable(listaNumeros)
			.filter(n -> n % 2 == 0)
			.map(n -> n * n)
			.subscribe(System.out::println);
		
		System.out.println("Cuadrados de los números pares del array");
		Flux.fromArray(arrayNumeros)
			.filter(n -> n % 2 == 0)
			.map(n -> n * n)
			.subscribe(System.out::println);
	}

}
