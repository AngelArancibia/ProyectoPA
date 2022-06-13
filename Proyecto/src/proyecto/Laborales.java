/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author angel
 */
public class Laborales extends Actividades {
    private String ubicacion;
    public Laborales (){}
    public Laborales(String Ubicacion, int horaInicio, int horaTermino, int minutosInicio, int minutosTermino) {
        super(horaInicio, horaTermino, minutosInicio, minutosTermino);
        this.ubicacion = Ubicacion;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String Ubicacion) {
        this.ubicacion = Ubicacion;
    }

    @Override
    public String generarReporte() {
        String reporte = "Reporte actividad laboral: \n";
        reporte += "Hora inicio: "+ this.getHoraInicio() + ":" + this.getMinutosInicio() + "\n";
        reporte += "Hora termino: "+ this.getHoraTermino() + ":" + this.getMinutosTermino() + "\n";
        reporte += "Lugar de trabajo: " + this.getUbicacion() + "\n";
        return reporte;
    }
    @Override
    public boolean siExiste(String tipo){
        return true;
    }

    @Override
    public void agregarActividadesTipo(AdmiProject auxProject,int horaInicio, int horaTermino, int minutosInicio, int minutosTermino, String identificador) {
        if(auxProject.siExiste("academica"))
            auxProject.agregarActividadData(horaInicio, horaTermino, minutosInicio, minutosTermino, "laboral");
                else
            auxProject.agregarActividadData(horaInicio, horaTermino, minutosInicio, minutosTermino, "Laboral");
        this.setUbicacion(identificador);
    }
    
}