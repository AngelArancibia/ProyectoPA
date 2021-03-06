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
public class OtroTipo extends Actividades {
    private String otroTipo;
    public OtroTipo(){}
    public OtroTipo(String otroTipo, int horaInicio, int horaTermino, int minutosInicio, int minutosTermino) {
        super(horaInicio, horaTermino, minutosInicio, minutosTermino);
        this.otroTipo = otroTipo;
    }
    public String getOtroTipo() {
        return otroTipo;
    }
    public void setOtroTipo(String otroTipo) {
        this.otroTipo = otroTipo;
    }

    @Override
    public String generarReporte() {
        String reporte = "Reporte actividad : " + this.getOtroTipo() + "\n";
        reporte += "Hora inicio: "+ this.getHoraInicio() + ":" + this.getMinutosInicio() + "\n";
        reporte += "Hora termino: "+ this.getHoraTermino() + ":" + this.getMinutosTermino() + "\n";
        return reporte;
    }
    @Override
    public boolean siExiste(String tipo){
        return tipo.equals(otroTipo);
    }
    @Override
    public void agregarActividadesTipo(AdmiProject auxProject, int horaInicio, int horaTermino, int minutosInicio, int minutosTermino, String tipoActividad) {
        
        if(auxProject.siExiste(tipoActividad))
            auxProject.agregarActividadData(horaInicio, horaTermino, minutosInicio, minutosTermino, tipoActividad.toLowerCase());
        else
            auxProject.agregarActividadData(horaInicio, horaTermino, minutosInicio, minutosTermino, tipoActividad);
        this.setOtroTipo(tipoActividad);
    }
}