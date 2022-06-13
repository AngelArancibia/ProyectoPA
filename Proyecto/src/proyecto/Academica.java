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
public class Academica extends Actividades {
    private String sala;
    public Academica (){}
    public Academica(String sala, int horaInicio, int horaTermino, int minutosInicio, int minutosTermino) {
        super(horaInicio, horaTermino, minutosInicio, minutosTermino);
        this.sala = sala;
    }
    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String generarReporte() {
        String reporte = "Reporte actividad academica: \n";
        reporte += "Hora inicio: "+ this.getHoraInicio() + ":" + this.getMinutosInicio() + "\n";
        reporte += "Hora termino: "+ this.getHoraTermino() + ":" + this.getMinutosTermino() + "\n";
        reporte += "Sala asignada: " + this.getSala() + "\n";
        return reporte;
    }
    @Override
    public boolean siExiste(String tipo){
        return true;
    }

    @Override
    public void agregarActividadesTipo(AdmiProject auxProject, int horaInicio, int horaTermino, int minutosInicio, int minutosTermino, String identificador) {
        
        if(auxProject.siExiste("academica"))
            auxProject.agregarActividadData(horaInicio, horaTermino, minutosInicio, minutosTermino, "academica");
        else
            auxProject.agregarActividadData(horaInicio, horaTermino, minutosInicio, minutosTermino, "Academica");
        this.setSala(identificador);
    }
}