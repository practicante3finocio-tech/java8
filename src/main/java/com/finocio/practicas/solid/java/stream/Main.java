package com.finocio.practicas.solid.java.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Creamos un Stream de Strings usando Stream.of()
        // Un Stream es una secuencia de elementos que se pueden procesar de forma funcional

        Stream<String> streamDeString = Stream.of("Antonio", "Maria", "Juan", "Pedro");

        // Convertimos el Stream en una lista usando collect() y Collectors.toList()
        // collect() es una operación terminal que transforma el Stream en otra estructura de datos

        List<String> lista = streamDeString.collect(Collectors.toList());

        System.out.println(lista);

        // Creamos un Stream de Strings usando Stream.of()
        // Un Stream es una secuencia de elementos que se pueden procesar de forma funcional
        // Usamos .filter para obtener los valores que contienen la letra "a"

        Stream<String> streamDeString1 = Stream.of("Antonio", "Maria", "Juan", "Pedro")
                .filter(s -> s.contains("a"));

        // Convertimos el Stream en una lista usando collect() y Collectors.toList()
        // collect() es una operación terminal que transforma el Stream en otra estructura de datos

        List<String> lista1 = streamDeString1.collect(Collectors.toList());
        System.out.println(lista1);


        // Creamos un Stream de Strings usando Stream.of()
        // Un Stream es una secuencia de elementos que se pueden procesar de forma funcional
        // Usamos .filter para filtrar los valores del stream que contengan la letra "A"
        // los transformamos con .map para que esos valores estén en mayusculas

        Stream<String> streamDeString2 = Stream.of("Antonio", "Maria", " Juan", "Pedro")
                .filter(s -> s.contains("A"))
                .map(s -> s.toUpperCase());
        List<String> lista2 = streamDeString2.collect(Collectors.toList());
        System.out.println(lista2);

    }
}
