public class Atributo implements Comparable<Atributo> {

    private Caracteristica caracteristica;
    private int puntaje;

    public Atributo(Caracteristica atrib, int i) {
        this.caracteristica = atrib;
        this.puntaje = i;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica carac) {
        this.caracteristica = carac;
    }

    public int getPuntos() {
        return puntaje;
    }

    public void setPuntos(int valor) {
        this.puntaje = valor;
    }

    public void incrementarPuntos(int valor) {
        this.puntaje += valor;
    }

    @Override
    public int compareTo(Atributo o) {
        return Integer.compare(this.getPuntos(), o.getPuntos());
    }

}
