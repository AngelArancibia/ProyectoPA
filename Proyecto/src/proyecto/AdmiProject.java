package proyecto;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AdmiProject  {
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in)); 
    private ArrayList<Dias> semana = new ArrayList<>();
    private HashMap<String,ActividadesData> actividadesData = new HashMap<>();
    public HashMap<String, ActividadesData> getActividadesData() {
        return actividadesData;
    }
    public void setActividadesData(HashMap<String, ActividadesData> actividadesData) {
        this.actividadesData = actividadesData;
    }
    public ArrayList<Dias> getSemana() {
        return semana;
    }
    public void setSemana(ArrayList<Dias> semana) {
        this.semana = semana;
    }
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
            int horaInicio = seleccionHora();
            int minutosInicio = seleccionMinutos();
            System.out.println("Ingrese hora de termino");
            int horaTermino = seleccionHora();
            int minutosTermino =  seleccionMinutos(); 
            switch(indice){
                case 1:
                    System.out.println("Indique el lugar de trabajo :");
                    String ubicacion = leer.readLine();
                    Laborales actividadLaboral = new Laborales();
                    exit = agregarActividadesTipo(actividadLaboral, horaInicio, horaTermino, minutosInicio, minutosTermino,seleccion,ubicacion);
                break;
                case 2:
                    System.out.println("Indique sala asignada :");
                    String sala = leer.readLine();
                    Academica actividadAcademica = new Academica();
                    exit = agregarActividadesTipo(actividadAcademica, horaInicio, horaTermino, minutosInicio, minutosTermino,seleccion,sala);
                break;
                case 3:
                    System.out.println("Indique el tipo de actividad :");
                    String tipoActividad = leer.readLine();
                    OtroTipo otroTipoActividad = new OtroTipo();
                    exit = agregarActividadesTipo(otroTipoActividad, horaInicio, horaTermino, minutosInicio, minutosTermino,seleccion,tipoActividad);
                break;
            }
        }
    }
    public boolean agregarActividadesTipo(Actividades auxActividades,int horaInicio, int horaTermino, int minutosInicio, int minutosTermino, int seleccion, String identificador){
        auxActividades.setHoraInicio(horaInicio);
        auxActividades.setMinutosInicio(minutosInicio);
        auxActividades.setHoraTermino(horaTermino);
        auxActividades.setMinutosTermino(minutosTermino);
        auxActividades.agregarActividadesTipo(this, horaInicio, horaTermino, minutosInicio, minutosTermino, identificador);
        if(semana.get(seleccion).agregarActividad(auxActividades)){ 
            System.out.println();
            System.out.println(" - La actividad se agrego correctamente.");
            System.out.println();
            return true;
        }else{
            try {
                System.out.println();
                System.out.println(" - La actividad presenta choque de horario.");
                System.out.println();
                System.out.println("1.- Volver a ingresar.");
                System.out.println("0.- Salir.");
                System.out.println();
                int i = Integer.parseInt(leer.readLine());
                if(i == 0)
                    return true;
            } catch (IOException ex) {
                Logger.getLogger(AdmiProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public void mostrarSemana(){
        for(int i = 0 ; i < 7 ; i++){
        System.out.println(semana.get(i).getNombre());
        System.out.println();
        semana.get(i).mostrarActividades();
        System.out.println();
        }
    }
    public void mostrarActividadesData() {
        if(actividadesData.isEmpty()){
            System.out.println("- No se registran actividades");
        }
        System.out.println("Las datos de las actividades son:");
        System.out.println();
        for(Map.Entry<String,ActividadesData> auxMapa : actividadesData.entrySet()){
            System.out.println(" - Tipo de actividad: "+auxMapa.getValue().getTipo());
            System.out.println("  * Horas totales: "+auxMapa.getValue().getDuracionTotalHoras()+" horas y "+auxMapa.getValue().getDuracionTotalMinutos()+" minutos." );
            System.out.println("  * Veces por semana: "+auxMapa.getValue().getVecesPorSemana()+" veces.");
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
                int nuevaHoraInicio = seleccionHora();
                int nuevosMinutosInicio = seleccionMinutos();
                System.out.println();
                System.out.println("Ingrese nueva hora de termino.");
                int nuevaHoraTermino = seleccionHora();
                int nuevoMinutosTermino = seleccionMinutos();
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
            if (seleccion < 0 || seleccion > 7)
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
            System.out.println(" - El archivo ya existe!. Se sobreescribira el reporte.");

        FileWriter creador = new FileWriter(archivoReporte);
        creador.write(reporte);
        creador.close();
    }
    public void actividadConMasHoras(){
        if(actividadesData.isEmpty()){
            System.out.println();
            System.out.println(" - No se regsitran actividades");
            return;
        }
        String auxKey = new String();
        int auxHoras = 0;
        int auxMinutos = 0;
        for(Map.Entry<String,ActividadesData> auxMapa : actividadesData.entrySet()){
            if (auxMapa.getValue().getDuracionTotalHoras() > auxHoras){ 
                auxHoras = auxMapa.getValue().getDuracionTotalHoras();
                auxMinutos = auxMapa.getValue().getDuracionTotalMinutos();
                auxKey = auxMapa.getKey();
            }
            else if(auxMapa.getValue().getDuracionTotalHoras() == auxHoras){
                if(auxMapa.getValue().getDuracionTotalMinutos() > auxMinutos){
                    auxHoras = auxMapa.getValue().getDuracionTotalHoras();
                    auxMinutos = auxMapa.getValue().getDuracionTotalMinutos();
                    auxKey = auxMapa.getKey();
                }        
            }
        }
        System.out.println();
        System.out.println(" - El tipo de actividad con mas horas es: "+actividadesData.get(auxKey).getTipo()+" con un total de "+actividadesData.get(auxKey).getDuracionTotalHoras()+" horas y "+actividadesData.get(auxKey).getDuracionTotalMinutos()+" minutos.");
    
    }
    public void actividadQueMasSeRepite(){
        if(actividadesData.isEmpty()){
            System.out.println();
            System.out.println(" - No se regsitran actividades");
            return;
        }
        String auxKey = new String();
        int auxRepeticiones = 0;
        
        for(Map.Entry<String,ActividadesData> auxMapa : actividadesData.entrySet()){
            if (auxMapa.getValue().getVecesPorSemana() > auxRepeticiones){ 
                auxRepeticiones = auxMapa.getValue().getDuracionTotalHoras();
                auxKey = auxMapa.getKey();
            }
        }
        System.out.println();
        System.out.println(" - El tipo de actividad con mas repeticiones es: "+actividadesData.get(auxKey).getTipo()+" con un total de "+actividadesData.get(auxKey).getVecesPorSemana()+" veces por semana");
    
    }  
    public int seleccionHora() throws IOException{
        boolean exit = false;
        int seleccion = 0;
        System.out.println("Ingrese hora :");
        while(!exit){
            seleccion = Integer.parseInt(leer.readLine());
            if (seleccion < 0 || seleccion > 23)
                System.out.println("Hora ingresada invalida. Por favor ingrese nuevamente :");
            else
                exit = true;
        }
        return seleccion;
        
    }
    public int seleccionMinutos() throws IOException{
        boolean exit = false;
        int seleccion = 0;
        System.out.println("Ingrese minutos :");
        while(!exit){
            seleccion = Integer.parseInt(leer.readLine());
            if (seleccion < 0 || seleccion > 60)
                System.out.println("Minutos ingresados invalidos. Por favor ingrese nuevamente :");
            else
                exit = true;
        }
        return seleccion;   
    }
    public void agregarActividadData(int horaInicio, int horaTermino, int minutosInicio, int minutosTermino, String tipo){
        int duracionTotalHoras =  horaTermino - horaInicio;
        if(duracionTotalHoras <= 0) duracionTotalHoras += 24;
        int duracionTotalMinutos = minutosTermino - minutosInicio;
        if(duracionTotalMinutos < 0){
            duracionTotalMinutos += 60;
            duracionTotalHoras += 1;
        }
        if (actividadesData.size() == 0 || actividadesData.get(tipo) == null){
            ActividadesData auxDatos = new ActividadesData();
            auxDatos.setTipo(tipo);
            auxDatos.setDuracionTotalHoras(duracionTotalHoras);
            auxDatos.setDuracionTotalMinutos(duracionTotalMinutos);
            auxDatos.setVecesPorSemana(1);
            actividadesData.put(tipo.toLowerCase(), auxDatos);
        }else{
            int vecesPorSemana = actividadesData.get(tipo).getVecesPorSemana();
            duracionTotalMinutos += actividadesData.get(tipo).getDuracionTotalMinutos();
            if(duracionTotalMinutos >= 60){
            actividadesData.get(tipo).setDuracionTotalMinutos(duracionTotalMinutos - 60);
            duracionTotalHoras += 1;
            }
            vecesPorSemana += 1;
            actividadesData.get(tipo).setVecesPorSemana(vecesPorSemana);
            duracionTotalHoras += actividadesData.get(tipo).getDuracionTotalHoras();
            actividadesData.get(tipo).setDuracionTotalHoras(duracionTotalHoras);
        }
    }
    public boolean siExiste(String tipo){
       for(Dias auxSemana : semana){
           for(int i = 0 ; i < auxSemana.getActividad().size(); i++){
               if(auxSemana.getActividad(i).siExiste(tipo))
                   return true;
            }
       }
       return false;
    }
}