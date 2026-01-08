package com.finocio.practicas.solid.java.lambda;

@FunctionalInterface

public interface Ejecutor {

    // Una interfaz funcional solo puede tener un método abstracto. Que no tenga ningun tipo de implementacion.

    // Métodos abstracto

    String ejecutar(String parametro);


}
