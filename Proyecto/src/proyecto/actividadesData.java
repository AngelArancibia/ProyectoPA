
package proyecto;


public class actividadesData {
    
    private String tipo;
    private int duracionTotal;
    private int vecesPorSemana;

    public actividadesData(String tipo, int duracionTotal, int vecesPorSemana) {
        this.tipo = tipo;
        this.duracionTotal = duracionTotal;
        this.vecesPorSemana = vecesPorSemana;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(int duracionTotal) {
        this.duracionTotal = duracionTotal;
    }

    public int getVecesPorSemana() {
        return vecesPorSemana;
    }

    public void setVecesPorSemana(int vecesPorSemana) {
        this.vecesPorSemana = vecesPorSemana;
    }

   
    
    
}
