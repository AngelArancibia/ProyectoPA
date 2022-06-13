
package proyecto;



public class ActividadesData {
    private String tipo;
    private int duracionTotalHoras;
    private int duracionTotalMinutos;
    private int vecesPorSemana;
    
    public ActividadesData(){
        
    }
    public ActividadesData(String tipo, int duracionTotal, int vecesPorSemana, int duracionTotalHoras, int duracionTotalMinutos) {
        this.tipo = tipo;
        this.duracionTotalHoras = duracionTotalHoras; 
        this.duracionTotalMinutos = duracionTotalMinutos;
        this.vecesPorSemana = vecesPorSemana;
    }

    public int getDuracionTotalHoras() {
        return duracionTotalHoras;
    }

    public void setDuracionTotalHoras(int duracionTotalHoras) {
        this.duracionTotalHoras = duracionTotalHoras;
    }

    public int getDuracionTotalMinutos() {
        return duracionTotalMinutos;
    }

    public void setDuracionTotalMinutos(int duracionTotalMinutos) {
        this.duracionTotalMinutos = duracionTotalMinutos;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVecesPorSemana() {
        return vecesPorSemana;
    }

    public void setVecesPorSemana(int vecesPorSemana) {
        this.vecesPorSemana = vecesPorSemana;
    }

   
    
    
}
