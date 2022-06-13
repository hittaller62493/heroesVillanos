package clases;
/*
 * Atributo de los competidores
 */
public class Atributo {

    private Caracteristica caracteristica;
    private double puntaje;
/*
 * Crea un atributo
 * @param atrib Caracteristica
 * @param puntaje 
 */
    public Atributo(Caracteristica atrib, double puntaje) {
        this.caracteristica = atrib;
        this.puntaje = puntaje;
    }

/*
 * @return el tipo de caracteristica.
 */
    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    // Eliminar
    public void setCaracteristica(Caracteristica carac) {
        this.caracteristica = carac;
    }
/*
 * @return cantidad de puntos.
 */
    public double getPuntos() {
        return puntaje;
    }
/*
 * @post seteamos los puntos con un valor.
 */
    public void setPuntos(double valor) {
        this.puntaje = valor;
    }
/*
 * @post aumenta los puntos previos.
 * @param valor
 */
    public void incrementarPuntos(double valor) {
        this.puntaje += valor;
    }
/*
 * @return todos los atributos.
 */
    @Override
    public String toString() {
        return "Atributo [caracteristica=" + caracteristica + ", puntaje=" + puntaje + "]";
    }

    

}
