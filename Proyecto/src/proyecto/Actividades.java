
package proyecto;


public class Actividades {
    
    private String tipo;
    private int horaInicio;
    private int horaTermino;

    public Actividades(String tipo, int horaInicio, int horaTermino) {
        this.tipo = tipo;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
    }
    public Actividades (){
        
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(int horaTermino) {
        this.horaTermino = horaTermino;
    }    
}
