
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
            System.out.println("1.- Agregar actividad.");
            System.out.println("2.- Eliminar actividad.");
            System.out.println("3.- Editar actividad.");
            System.out.println("4.- Mostrar semana.");
            System.out.println("5.- Mostrar datos de las actividades.");
            System.out.println("6.- Generar reporte");
            System.out.println("7.- Mostrar tipo de actividad con mayor duracion.");
            System.out.println("8.- Mostrar tipo de actividad que mas se repite.");
            System.out.println("0.- Salir.");
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
                case 5:
                    Administrador.mostrarActividadesData();
                break;    
                case 6:
                    Administrador.generarReporteGeneral();
                break;
                case 7:
                    Administrador.actividadConMasHoras();
                break;
                case 8:
                    Administrador.actividadQueMasSeRepite();
                break;
                case 0:
                    exit = 0;
                break;
            }
        }
    }
}