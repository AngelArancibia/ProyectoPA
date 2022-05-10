package proyecto;

import java.util.*;
import java.io.*;

public class AdmiProject  {
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in)); 
    private Semana[] dias = new Semana[7];
    public AdmiProject(){
        
    }
    public void setDias(){        
    dias[0]= new Semana("Lunes");
    dias[1]= new Semana("Martes");
    dias[2]= new Semana("Miercoles");
    dias[3]= new Semana("Jueves");
    dias[4]= new Semana("Viernes");
    dias[5]= new Semana("Sabado");
    dias[6]= new Semana("Domingo");
    }
    
    
    public void agregarActividad() throws IOException {
        boolean exit = false;
        while(exit == false){
            System.out.println("Semana :");
            for ( int i = 0 ; i < 7 ; i++){
                System.out.println("  " + (i+1) + ".- " + dias[i].getDia());
            }
            System.out.println();
            System.out.println("Seleccione dia al cual agregara la actividad :");
            int seleccion = Integer.parseInt(leer.readLine()) - 1;
            System.out.println("Especifique el tipo de actividad :");
            String tipo = leer.readLine();
            System.out.println("Ingrese hora de incio :");
            int horaIni =  Integer.parseInt(leer.readLine());
            System.out.println("Ingrese hora de termino :");
            int horaTerm =  Integer.parseInt(leer.readLine());
            Actividades aux = new Actividades();
            aux.setHoraInicio(horaIni);
            aux.setHoraTermino(horaTerm);
            aux.setTipo(tipo);
            if(dias[seleccion].agregarActividad(aux)){ 
                System.out.println();
                System.out.println(" - La actividad se agrego correctamente.");
                System.out.println();
                exit = true;
            }else{
                System.out.println();
                System.out.println(" - La actividad presenta choque de horario.");
                System.out.println();
                System.out.println("1.- Volver a ingresar.");
                System.out.println("0.- Salir.");
                System.out.println();
                int indice = Integer.parseInt(leer.readLine());
                if(indice == 0)
                    exit = true;
                else
                    exit = false;
                
            }
        }
    }
    

    public void mostrarSemana(){
        for(int i = 0 ; i < 7 ; i++){
        System.out.println(dias[i].getDia());
        System.out.println();
        dias[i].mostrarActividades();
        System.out.println();
        }
    }
    public void eliminarActividad() throws IOException{
        System.out.println();
        System.out.println("Semana :");
        for ( int i = 0 ; i < 7 ; i++){
            System.out.println( (i+1) + ".- " + dias[i].getDia());
        }
        System.out.println();
        System.out.println("Seleccione dia del cual desea eliminar una actividad :");
        int seleccion = Integer.parseInt(leer.readLine()) - 1;
        if(dias[seleccion].verificarVacio()){
            System.out.println();
            System.out.println("Lista de actividades dia " + dias[seleccion].getDia());
            dias[seleccion].mostrarActividades();
            System.out.println();
            System.out.println("Seleccione la actividad que desea eliminar :");

            int seleccionActividad = Integer.parseInt(leer.readLine());
            dias[seleccion].eliminarActividad(seleccionActividad - 1);
            System.out.println();
            System.out.println(" - La actividad se elimino correctamente.");
            System.out.println();
        }else{
            System.out.println();
            System.out.println(" - El dia no registra actividades para eliminar.");
            System.out.println();
        }
    }
    public void editarActividad() throws IOException{
          System.out.println("Semana :");
        for ( int i = 0 ; i < 7 ; i++){
            System.out.println("  " + (i+1) + ".- " + dias[i].getDia());
        }
        System.out.println();
        System.out.println("Seleccione dia del cual editara la actividad :");
        int seleccion = Integer.parseInt(leer.readLine()) - 1;
        System.out.println();
        dias[seleccion].mostrarActividades();
        System.out.println();
        System.out.println("Seleccione seleccione la actividad que desea editar :");
        int seleccionActividad = Integer.parseInt(leer.readLine()) - 1;
        System.out.println();
        System.out.println("Que desea editar en la actividad :");
        System.out.println();
        System.out.println("1.- Editar hora.");
        System.out.println("2.- Editar dia");
        System.out.println();
        int indice = Integer.parseInt(leer.readLine());
        switch(indice){
            case 1:{
                boolean exit = false;
                while(exit == false){
                System.out.println();
                System.out.println("Ingrese nueva hora de inicio.");
                int nuevaHoraInicio = Integer.parseInt(leer.readLine());
                System.out.println();
                System.out.println("Ingrese nueva hora de termino.");
                int nuevaHoraTermino = Integer.parseInt(leer.readLine());
                System.out.println();
                    if(dias[seleccion].verificarVacio()){
                        System.out.println();
                        System.out.println(" - El dia no registra actividades.");
                        System.out.println();
                        exit = true;
                    }else{
                        if(dias[seleccion].cambiarHora(seleccionActividad, nuevaHoraInicio, nuevaHoraTermino)){
                            System.out.println();
                            System.out.println(" - La hora se cambio correctamente.");
                            System.out.println();
                            exit = true;
                        }else{
                            System.out.println();
                            System.out.println(" - La nueva hora ingresada presenta choque de horarios.");
                            System.out.println();
                            System.out.println("1.- Ingresar nuevamente.");
                            System.out.println("0.- Salir");
                            System.out.println();
                            int opcion = Integer.parseInt(leer.readLine());
                            if(opcion == 0)
                                exit = true;
                            else
                                exit = false;
                        }
                    }
                }
                break;
            }
            case 2:{
                Actividades actividadAux = new Actividades();
                actividadAux = dias[seleccion].getActividad(seleccionActividad);
                boolean exit = false;
                while(exit == false){
                    System.out.println();
                    System.out.println("Semana :");
                    for ( int i = 0 ; i < 7 ; i++){
                        System.out.println("  " + (i+1) + ".- " + dias[i].getDia());
                    }
                    System.out.println();
                    System.out.println("Seleccion el dia al cual desea mover la actividad.");
                    System.out.println();
                    int nuevoDia = Integer.parseInt(leer.readLine()) - 1;
                    System.out.println();
                    if(dias[nuevoDia ].agregarActividad(actividadAux)){
                        System.out.println(" - La actividad se cambio de dia correctamente.");
                        dias[seleccion].eliminarActividad(seleccionActividad);
                        exit = true;
                    }else{
                        System.out.println(" - La actividad que desea cambiar presenta choque de horario en el dia seleccionado.");
                        System.out.println();
                        System.out.println("1.- Intentar con otro dia.");
                        System.out.println("2.- Salir");
                        System.out.println();
                        int opcion = Integer.parseInt(leer.readLine());
                        if (opcion == 0)
                            exit = true;
                        else
                            exit = false;
                    }
                }
                break;
            }
        }
    }
}
   

