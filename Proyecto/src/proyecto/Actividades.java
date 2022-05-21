
package proyecto;


public abstract class Actividades implements Reporte {
    
    private int horaInicio;
    private int horaTermino;
    private int minutosInicio;
    private int minutosTermino;

    public Actividades(int horaInicio, int horaTermino, int minutosInicio, int minutosTermino) {
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.minutosInicio = minutosInicio;
        this.minutosTermino = minutosTermino;
    }

    public int getMinutosInicio() {
        return minutosInicio;
    }

    public void setMinutosInicio(int minutosInicio) {
        this.minutosInicio = minutosInicio;
    }

    public int getMinutosTermino() {
        return minutosTermino;
    }

    public void setMinutosTermino(int minutosTermino) {
        this.minutosTermino = minutosTermino;
    }
    public Actividades (){
        
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