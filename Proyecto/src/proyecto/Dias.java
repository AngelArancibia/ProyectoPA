
package proyecto;

import java.util.*;


public class Dias implements Reporte{
    
 private String nombre;
 private ArrayList<Actividades> actividad;
 
    public Dias(){
        
    }
    public Dias(String dia) {
        this.nombre = dia;
        this.actividad = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
   
    public void setNombre(String dia) {
        this.nombre = dia;
    }

    public ArrayList<Actividades> getActividad() {
        return actividad;
    }
    /*Aqui se realiza la anidacion de arreglos ya que cada dia de la semana tendra anidado
    su actividad y caracteristicas correspondientes.*/
    public boolean agregarActividad (Actividades aux){
        if(actividad.size() == 0){
            actividad.add(aux);
            return true;
        }else{
            for(int i = 0 ; i < actividad.size() ; i++){
                if((actividad.get(i).getHoraInicio() > aux.getHoraInicio() && actividad.get(i).getHoraInicio() < aux.getHoraTermino()) || (actividad.get(i).getHoraTermino() > aux.getHoraInicio() && actividad.get(i).getHoraTermino() < aux.getHoraTermino()) ){
                    return false;
                }else{
                    if((actividad.get(i).getHoraInicio() == aux.getHoraTermino() && actividad.get(i).getMinutosInicio()< aux.getMinutosTermino()) || (actividad.get(i).getHoraTermino() == aux.getHoraInicio() && actividad.get(i).getMinutosTermino()> aux.getMinutosInicio()))
                        return false;
                    else{
                    actividad.add(aux); 
                    return true;
                    }
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
                if(actividad.get(i) instanceof Laborales){
                    System.out.println(" - Actividad " + (i+1) + ":");
                    Laborales actividadAux = (Laborales)actividad.get(i);
                    System.out.println("   * Tipo de actividad: Laboral.");
                    if(actividad.get(i).getHoraInicio() < 10) System.out.print("   * Hora inicio: 0" + actividadAux.getHoraInicio());
                    else System.out.print("   * Hora inicio: " + actividadAux.getHoraInicio());
                    if(actividad.get(i).getMinutosInicio() == 0) System.out.println(":"+actividadAux.getMinutosInicio()+"0");
                    else System.out.println(":"+actividadAux.getMinutosInicio());
                    if(actividad.get(i).getHoraTermino() < 10) System.out.print("   * Hora termino: 0" + actividadAux.getHoraTermino());
                    else System.out.print("   * Hora inicio: " + actividadAux.getHoraTermino());
                    if(actividad.get(i).getMinutosTermino() == 0) System.out.println(":"+actividadAux.getMinutosTermino()+"0");
                    else System.out.println(":"+actividadAux.getMinutosTermino());
                }
                if(actividad.get(i) instanceof Academica){
                    System.out.println(" - Actividad " + (i+1) + ":");
                    Academica actividadAux = (Academica)actividad.get(i);
                    System.out.println("   * Tipo de actividad: Academica.");
                    if(actividad.get(i).getHoraInicio() < 10) System.out.print("   * Hora inicio: 0" + actividadAux.getHoraInicio());
                    else System.out.print("   * Hora inicio: " + actividadAux.getHoraInicio());
                    if(actividad.get(i).getMinutosInicio() == 0) System.out.println(":"+actividadAux.getMinutosInicio()+"0");
                    else System.out.println(":"+actividadAux.getMinutosInicio());
                    if(actividad.get(i).getHoraTermino() < 10) System.out.print("   * Hora termino: 0" + actividadAux.getHoraTermino());
                    else System.out.print("   * Hora inicio: " + actividadAux.getHoraTermino());
                    if(actividad.get(i).getMinutosTermino() == 0) System.out.println(":"+actividadAux.getMinutosTermino()+"0");
                    else System.out.println(":"+actividadAux.getMinutosTermino());
                }
                if(actividad.get(i) instanceof OtroTipo){
                    System.out.println(" - Actividad " + (i+1) + ":");
                    OtroTipo actividadAux = (OtroTipo)actividad.get(i);
                    System.out.println("   * Tipo de actividad: "+ actividadAux.getOtroTipo()+".");
                    if(actividad.get(i).getHoraInicio() < 10) System.out.print("   * Hora inicio: 0" + actividadAux.getHoraInicio());
                    else System.out.print("   * Hora inicio: " + actividadAux.getHoraInicio());
                    if(actividad.get(i).getMinutosInicio() == 0) System.out.println(":"+actividadAux.getMinutosInicio()+"0");
                    else System.out.println(":"+actividadAux.getMinutosInicio());
                    if(actividad.get(i).getHoraTermino() < 10) System.out.print("   * Hora termino: 0" + actividadAux.getHoraTermino());
                    else System.out.print("   * Hora inicio: " + actividadAux.getHoraTermino());
                    if(actividad.get(i).getMinutosTermino() == 0) System.out.println(":"+actividadAux.getMinutosTermino()+"0");
                    else System.out.println(":"+actividadAux.getMinutosTermino());
                }
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

    @Override
    public String generarReporte() {
        String reporte = "Dia " + this.getNombre() + "\n";
        if(actividad.size() == 0)
            reporte += " - El dia no registra actividades.\n";
        else{
            for(Actividades aux : actividad){
                reporte+= aux.generarReporte();
            }
        }
        return reporte;
    }
    
}