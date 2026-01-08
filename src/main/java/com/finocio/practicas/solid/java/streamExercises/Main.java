package com.finocio.practicas.solid.java.streamExercises;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        // 1. Obtener la cantidad de cursos con una duración mayor a 5 horas.

        long cursosMayorACincoHoras = cursos.stream()
                .filter(curso -> curso.getDuracion() > 5)
                .count();

        System.out.println(cursosMayorACincoHoras);

        // 2. Obtener la cantidad de cursos con una duración menor a 2 horas.

        long cursosMenorADosHoras = cursos.stream()
                .filter(curso -> curso.getDuracion() < 2)
                .count();

        System.out.println(cursosMenorADosHoras);

        // 3. Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.

        List<String> cursosVideosMayorACincuenta = cursos.stream()
                .filter(curso -> curso.getVideos() > 50)
                .map(curso -> curso.getTitulo())
                .collect(Collectors.toList());

        System.out.println(cursosVideosMayorACincuenta);

        // 4. Mostrar en consola el título de los 3 cursos con mayor duración.

        List<String> tresCursosMayorDuracion = cursos.stream()
                .sorted((c1, c2) -> Float.compare(c2.getDuracion(), c1.getDuracion()))
                .limit(3)
                .map(curso -> curso.getTitulo())
                .collect(Collectors.toList());

        System.out.println(tresCursosMayorDuracion);

        // 5. Mostrar en consola la duración total de todos los cursos.

        List<Float> duracionTotalTodosCursos = cursos.stream()
                .map(Curso::getDuracion)
                .collect(Collectors.toList());

        System.out.println(duracionTotalTodosCursos);

        // 6. Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.

        double promedioDuracion = cursos.stream()
                .mapToDouble(Curso::getDuracion)
                .average()
                .orElse(0);
        System.out.println(promedioDuracion);

        List<String> cursosMayorAPromedio = cursos.stream()
                .filter(curso -> curso.getDuracion() > promedioDuracion)
                .map(Curso::getTitulo)
                .collect(Collectors.toList());

        System.out.println(cursosMayorAPromedio);

        // 7. Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.

        List<Float> cursosDuracionMenorAQuinientosAlumnos = cursos.stream()
                .filter(curso -> curso.getAlumnos() < 500 )
                .map(Curso::getDuracion)
                .collect(Collectors.toList());

        System.out.println(cursosDuracionMenorAQuinientosAlumnos);
        // 8. Obtener el curso con mayor duración.

        Optional<Curso> cursoMayorDuracion = cursos.stream()
                .max(Comparator.comparingDouble(Curso::getDuracion));

        cursoMayorDuracion.ifPresent(curso ->
                System.out.println("Curso con mayor duración " + curso.getTitulo() + " (" + curso.getDuracion() + " horas)"));

        // 9. Crear una lista de Strings con todos los titulos de los cursos.

        List<String> todosTitulosCursos = cursos.stream()
                .map(Curso::getTitulo)
                .collect(Collectors.toList());

        System.out.println(todosTitulosCursos);

    }
}
