
package proyecto;

import java.util.*;


public class Dias {
    
 private String nombre;
 private ArrayList<Actividades> actividad;
 
    public Dias(){
        
    }
    public Dias(String dia) {
        this.nombre = dia;
        this.actividad = new ArrayList<Actividades>();
    }

    public String getNombre() {
        return nombre;
    }
   
    public void setNombre(String dia) {
        this.nombre = dia;
    }
    /*Aqui se realiza la anidacion de arreglos ya que cada dia de la semana tendra anidado
    su actividad y caracteristicas correspondientes.*/
    public boolean agregarActividad (Actividades aux){
        if(actividad.size() == 0){
            actividad.add(aux);
            return true;
        }else{
            for(int i = 0 ; i <actividad.size() ; i++){
                if(actividad.get(i).getHoraInicio() == aux.getHoraInicio()){
                    return false;
                }else{
                    actividad.add(aux); 
                    return true;
                }
            }
        }
        return true;
    } 
    public void mostrarActividades(){
        if(actividad.size() == 0){
            System.out.println(" - El dia no registra actividades.");
        }else{
            for(int i = 0 ; i < actividad.size() ; i++){
                System.out.println(" - Actividad " + (i+1) + ":");
                Actividades actividadAux = actividad.get(i);
                System.out.println("   * Tipo: " + actividadAux.getTipo());
                System.out.println("   * Hora inicio: " + actividadAux.getHoraInicio());
                System.out.println("   * Hora termino: " + actividadAux.getHoraTermino());
            }
        }
    }
    public void eliminarActividad(int selecionActividad){
            actividad.remove(selecionActividad);
    }
    public boolean verificarVacio(){
        if(actividad.size() == 0)
            return false;
        else
            return true;
    }
    public boolean cambiarHora(int seleccionActividad, int horaIniNueva, int horaTermNueva){
         for(int i = 0 ; i <actividad.size() ; i++){
                if(actividad.get(i).getHoraInicio() == horaIniNueva){
                    return false;
                }else{
                    actividad.get(seleccionActividad).setHoraInicio(horaIniNueva);
                    actividad.get(seleccionActividad).setHoraTermino(horaTermNueva);
                    return true;
                }
            }
         return true;
    }
    public Actividades getActividad(int seleccionActividad){
        return actividad.get(seleccionActividad);
    }
}
    
    
   


    




