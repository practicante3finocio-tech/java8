package com.finocio.practicas.solid.java.lamdaExercises;

import java.util.Arrays;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1. Crear una función anónima que nos permita calcular el promedio de un arreglo de números enteros.

        ToDoubleFunction<int[]> promedio = arr ->
                Arrays.stream(arr).average().orElse(0);

        int []numeros = {10, 20, 30, 40};
        System.out.println(promedio.applyAsDouble(numeros));

        // 2. Crear una función anónima que calcule el factorial dado un número entero.

        IntFunction<Long> factorial = n -> {
            long resultado = 1;
            for(int i = 1; i <= n; i++){
                resultado *= i;
            }
            return  resultado;
        };

        System.out.println(factorial.apply(5));

        // 3. Crear una función anónima que permita conocer si un número es par.

        IntPredicate esPar = n -> n % 2 == 0;
        int numero = 10;
        if (esPar.test(numero)) {
            System.out.println("El " + numero + " es par: ");
        } else {
            System.out.println("El " + numero + " es impar: ");
        }

        System.out.println(esPar.test(10));
        System.out.println(esPar.test(5));



        // 4. Dado un arreglo de números enteros, crear una función anónima que retorne el número mayor.

        ToIntFunction<int[]> maximo = arr ->
                Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);

        System.out.println(maximo.applyAsInt(new int[]{1,2,3,4,5,6,7,8,9}));

        // 5. Dado un arreglo de números enteros, crear una función anónima que retorne el número menor.

        ToIntFunction<int[]> minimo = arr ->
                Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);

        System.out.println(minimo.applyAsInt(new int[]{1,2,3,4,5,6,7,8,9,0}));

        // 6. Dado un arreglo de números enteros, crear una función anónima que retorne el número que más se repite.

        ToIntFunction<int[]> masRepetido = arr ->
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .get()
                        .getKey();

        System.out.println(masRepetido.applyAsInt(new int[]{10,20,30,40,40,40,50,50}));


        // 7. Crear una función anónima que reciba como parámetro 3 numeros enteros. La función retorna el número mayor.

        TriFunction<Integer, Integer, Integer, Integer> maximoTres = (a,b,c) ->
                Math.max(a, Math.max(b, c));

        System.out.println(maximoTres.apply(10,20,30));

        // 8. Crear una función anónima que reciba dos parámetros, un string el cual será el resultado
        // de multiplicar ambos parámetros.


        BiFunction<String, Integer, String> repetirString = (s, n) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(s);
            }

            return sb.toString();
        };

        String resultado = repetirString.apply("Hola", 3);
        System.out.println(resultado);

    }
    }

