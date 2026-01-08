package com.finocio.practicas.solid.java.lambda;

import java.sql.SQLOutput;

public class MainClaseAnonima {
    public static void main(String[] args) {

        // Clase anonima a través de una clase

        new Vehiculo(){
            private int numeroPasajeros;

            public void conducir() {
                System.out.println("Estoy conduciendo");
            }

        }.conducir();

        // Clase anonima a través de una interfaz

        UsuarioServicio usuarioServicio = new UsuarioServicio(){
            @Override
            public void crearUsuario() {
                System.out.println("Creando usuario");
            }
        };

        usuarioServicio.crearUsuario();

        //

        claseAnonimaVehiculo(new Vehiculo(){

        });

        claseAnonimaInterfaz(new UsuarioServicio() {
            @Override
            public void crearUsuario() {

            }
        });

    }

    public static void claseAnonimaVehiculo(Vehiculo vehiculo) {

    }

    public static void claseAnonimaInterfaz(UsuarioServicio usuarioServicio){

    }
}
