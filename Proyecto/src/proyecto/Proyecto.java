
package proyecto;

import java.util.*;
import java.io.*;

public class Proyecto{
    public static void main(String[] args) throws IOException {
        
        AdmiProject Administrador = new AdmiProject();       
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Administrador.setDias();
        int exit = 1;
        while (exit != 0){
            System.out.println();
            System.out.println("1.- Agregar actividad");
            System.out.println("2.- Eliminar actividad");
            System.out.println("3.- Editar actividad");
            System.out.println("4.- Mostrar semana");
           
            System.out.println("0.- Salir");
            int seleccion = Integer.parseInt(leer.readLine());
            switch (seleccion){
                case 1:
                    Administrador.agregarActividad();
                    break;
                case 2:
                    Administrador.eliminarActividad();
                    break;
                case 3:
                    Administrador.editarActividad();
                    break;
                case 4:
                    Administrador.mostrarSemana();
                    break;
                case 0:
                    exit = 0;
                    break;
            }
        }
    }
}
    
