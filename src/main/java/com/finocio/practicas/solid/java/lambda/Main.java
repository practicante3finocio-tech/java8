package com.finocio.practicas.solid.java.lambda;

public class Main {
    public static void main(String[] args) {

        // Implementación de la interfaz Ejecutor usando una CLASE ANÓNIMA
        // Se crea una clase sin nombre que implementa Ejecutor

        Ejecutor claseAnonimaEjecutor = new Ejecutor() {
            @Override
            public String ejecutar(String parametro) {
                System.out.println("Hola desde una " + parametro);
                return parametro.toUpperCase();
            }
        };

        // Implementación de la interfaz Ejecutor usando una EXPRESIÓN LAMBDA
        // Es una forma más corta y clara de definir la lógica

        Ejecutor lambdaEjecutor = (String parametro) -> {
            System.out.println("Hola desde nuestra " + parametro);
            return parametro.toLowerCase();
        };

        String resultadoClaseAnonima = claseAnonimaEjecutor.ejecutar("clase anónima");
        String resultadoLamda = lambdaEjecutor.ejecutar("lamda");
        System.out.println(resultadoLamda);
        System.out.println(resultadoClaseAnonima);

    }
}
