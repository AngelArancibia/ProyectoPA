package proyecto;

import java.util.*;
import java.io.*;

public class AdmiProject  {
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in)); 
    private ArrayList<Dias> semana = new ArrayList<>();
    public AdmiProject(){
        
    }
    public void setDias(){
        for(int i = 0; i < 7; i++){
            Dias aux = null;
            switch (i){
                case 0:
                    aux = new Dias("Lunes");
                    break;
                case 1:
                    aux = new Dias("Martes");
                    break;
                case 2:
                    aux = new Dias("Miercoles");
                    break;
                case 3:
                    aux = new Dias("Jueves");
                    break;
                case 4:
                    aux = new Dias("Viernes");
                    break;
                case 5:
                    aux = new Dias("Sabado");
                    break;
                case 6:
                    aux = new Dias("Domingo");
                    break;
            }
            semana.add(aux);
        }
        
    }
    
    
    public void agregarActividad() throws IOException {
        boolean exit = false;
        while(!exit){
            System.out.println("Semana :");
            for ( int i = 0 ; i < 7 ; i++){
                System.out.println("  " + (i+1) + ".- " + semana.get(i).getNombre());
            }
            System.out.println();
            int seleccion = seleccionDia();
            System.out.println("Especifique el tipo de actividad ");
            System.out.println("1.- Laboral.");
            System.out.println("2.- Academica.");
            System.out.println("3.- Otros.");
            System.out.println("0.- Salir.");
            System.out.println();
            int indice = Integer.parseInt(leer.readLine());
            if(indice == 0){
                break;
            }
            System.out.println("Ingrese hora de incio");
            System.out.println("Ingrese hora :");
            int horaInicio =  Integer.parseInt(leer.readLine());
            System.out.println("Ingrese minutos :");
            int minutosInicio =  Integer.parseInt(leer.readLine());
            System.out.println("Ingrese hora de termino");
            System.out.println("Ingrese hora :");
            int horaTermino =  Integer.parseInt(leer.readLine());
            System.out.println("Ingrese minutos :");
            int minutosTermino =  Integer.parseInt(leer.readLine());
            switch(indice){
                case 1:
                    System.out.println("Indique el lugar de trabajo :");
                    String ubicacion = leer.readLine();
                    Laborales actividadLaboral = new Laborales();
                    actividadLaboral.setHoraInicio(horaInicio);
                    actividadLaboral.setMinutosInicio(minutosInicio);
                    actividadLaboral.setHoraTermino(horaTermino);
                    actividadLaboral.setMinutosTermino(minutosTermino);
                    actividadLaboral.setUbicacion(ubicacion);
                    if(semana.get(seleccion).agregarActividad(actividadLaboral)){ 
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
                    int i = Integer.parseInt(leer.readLine());
                    if(i == 0)
                        exit = true;
                    }
                break;
                case 2:
                    System.out.println("Indique sala asignada :");
                    String sala = leer.readLine();
                    Academica actividadAcademica = new Academica();
                    actividadAcademica.setHoraInicio(horaInicio);
                    actividadAcademica.setMinutosInicio(minutosInicio);
                    actividadAcademica.setHoraTermino(horaTermino);
                    actividadAcademica.setMinutosTermino(minutosTermino);
                    actividadAcademica.setSala(sala);
                    if(semana.get(seleccion).agregarActividad(actividadAcademica)){ 
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
                    int i = Integer.parseInt(leer.readLine());
                    if(i == 0)
                        exit = true;
                    }
                break;
                case 3:
                    System.out.println("Indique sala asignada :");
                    String tipoActividad = leer.readLine();
                    OtroTipo otroTipoActividad = new OtroTipo();
                    otroTipoActividad.setHoraInicio(horaInicio);
                    otroTipoActividad.setMinutosInicio(minutosInicio);
                    otroTipoActividad.setHoraTermino(horaTermino);
                    otroTipoActividad.setMinutosTermino(minutosTermino);
                    otroTipoActividad.setOtroTipo(tipoActividad);
                    if(semana.get(seleccion).agregarActividad(otroTipoActividad)){ 
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
                    int i = Integer.parseInt(leer.readLine());
                    if(i == 0)
                        exit = true;
                    }
                break;
            }
        }
    }
    

    public void mostrarSemana(){
        for(int i = 0 ; i < 7 ; i++){
        System.out.println(semana.get(i).getNombre());
        System.out.println();
        semana.get(i).mostrarActividades();
        System.out.println();
        }
    }
    public void eliminarActividad() throws IOException{
        System.out.println();
        System.out.println("Semana :");
        for ( int i = 0 ; i < 7 ; i++){
            System.out.println( (i+1) + ".- " + semana.get(i).getNombre());
        }
        System.out.println();
        int seleccion = seleccionDia();
        if(semana.get(seleccion).verificarVacio()){
            System.out.println();
            System.out.println("Lista de actividades dia " + semana.get(seleccion).getNombre());
            semana.get(seleccion).mostrarActividades();
            System.out.println();
            System.out.println("Seleccione la actividad que desea eliminar :");
            int seleccionActividad = Integer.parseInt(leer.readLine()) - 1;
            semana.get(seleccion).eliminarActividad(seleccionActividad);
            System.out.println();
            System.out.println(" - La actividad se elimino correctamente.");
            System.out.println();
        }else{
            System.out.println();
            System.out.println(" - El dia " + semana.get(seleccion).getNombre() + " no registra actividades para eliminar.");
            System.out.println();
        }
    }
    public void editarActividad() throws IOException{
          System.out.println("Semana :");
        for ( int i = 0 ; i < 7 ; i++){
            System.out.println("  " + (i+1) + ".- " + semana.get(i).getNombre());
        }
        System.out.println();
        int seleccion = seleccionDia();
        System.out.println();
        semana.get(seleccion).mostrarActividades();
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
                System.out.println("Ingrese hora :");
                int nuevaHoraInicio = Integer.parseInt(leer.readLine());
                System.out.println("Ingrese minutos :");
                int nuevosMinutosInicio = Integer.parseInt(leer.readLine());
                System.out.println();
                System.out.println("Ingrese nueva hora de termino.");
                System.out.println("Ingrese hora :");
                int nuevaHoraTermino = Integer.parseInt(leer.readLine());
                System.out.println("Ingrese minutos :");
                int nuevoMinutosTermino = Integer.parseInt(leer.readLine());
                System.out.println();
                        if(semana.get(seleccion).cambiarHora(seleccionActividad, nuevaHoraInicio, nuevaHoraTermino)){
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
                break;
                }
            case 2:{
                Actividades actividadAux;
                actividadAux = semana.get(seleccion).getActividad(seleccionActividad);
                boolean exit = false;
                while(exit == false){
                    System.out.println();
                    System.out.println("Semana :");
                    for ( int i = 0 ; i < 7 ; i++){
                        System.out.println("  " + (i+1) + ".- " + semana.get(i).getNombre());
                    }
                    System.out.println();
                    System.out.println("Seleccion el dia al cual desea mover la actividad.");
                    System.out.println();
                    int nuevoDia = Integer.parseInt(leer.readLine()) - 1;
                    System.out.println();
                    if(semana.get(nuevoDia).agregarActividad(actividadAux)){
                        System.out.println(" - La actividad se cambio de dia correctamente.");
                        semana.get(seleccion).eliminarActividad(seleccionActividad);
                        exit = true;
                    }else{
                        System.out.println(" - La actividad que desea cambiar presenta choque de horario en el dia seleccionado.");
                        System.out.println();
                        System.out.println("1.- Intentar con otro dia.");
                        System.out.println("2.- Salir");
                        System.out.println();
                        int opcion = Integer.parseInt(leer.readLine());
                        if (opcion == 0) exit = true;
                    }
                }
            break;
            }
        }
    }
    private int seleccionDia() throws IOException{
        boolean exit = false;
        int seleccion = 0;
        System.out.println("Seleccione dia al cual agregara la actividad :");
        while(!exit){
            seleccion = Integer.parseInt(leer.readLine()) - 1;
            if (seleccion < 0 || seleccion > 8)
                System.out.println("Dia seleccionado invalido. Por favor ingrese nuevamente :");
            else
                exit = true;
        }
        return seleccion;
    }
    public void generarReporteGeneral() throws IOException{
        String reporte = "";
        for(Dias auxDias : semana){
            reporte+= auxDias.generarReporte();
        }
        File archivoReporte = new File("Reporte_General.txt");
        if (archivoReporte.createNewFile())
            System.out.println("Archivo creado: " + archivoReporte.getName());
        else
            System.out.println("El archivo ya existe!. Se sobreescribira el reporte.");

        FileWriter creador = new FileWriter(archivoReporte);
        creador.write(reporte);
        creador.close();
    }
}