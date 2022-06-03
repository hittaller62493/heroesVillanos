public class Caracteristicas {
    
    private Caracteristica caracteristica;
    private int puntos;

    public Caracteristicas(Caracteristica atributo, int puntos) {
        this.caracteristica = atributo;
        this.puntos = puntos;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public int getPuntos() {
        return puntos;
    }
    
}
