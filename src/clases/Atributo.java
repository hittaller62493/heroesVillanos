package clases;

public class Atributo implements Comparable<Atributo> {

    private Caracteristica caracteristica;
    private double puntaje;

    public Atributo(Caracteristica atrib, double i) {
        this.caracteristica = atrib;
        this.puntaje = i;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    // Eliminar
    public void setCaracteristica(Caracteristica carac) {
        this.caracteristica = carac;
    }

    public double getPuntos() {
        return puntaje;
    }

    public void setPuntos(double valor) {
        this.puntaje = valor;
    }

    public void incrementarPuntos(double valor) {
        this.puntaje += valor;
    }

    @Override
    public int compareTo(Atributo o) {
        return Double.compare(this.getPuntos(), o.getPuntos());
    }

    @Override
    public String toString() {
        return "Atributo [caracteristica=" + caracteristica + ", puntaje=" + puntaje + "]";
    }

    

}