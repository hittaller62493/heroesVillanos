package main;

import java.util.Comparator;

import clases.Caracteristica;
import clases.Competidor;
/*
 * Ordenador de caracteristicas en descendente que utiliza un comparador de competidor.
 */

public class OrdenadorCaracteristicaDescendente implements Comparator<Competidor> {

    private Caracteristica caracteristicaUno;
    private Caracteristica caracteristicaDos;
    /*
    * Crea un ordenador de caracteristica descendente con las caracteristicas dadas.
    * @param c1
    * @param c2
    */
    public OrdenadorCaracteristicaDescendente(Caracteristica c1, Caracteristica c2) {
        this.caracteristicaUno = c1;
        this.caracteristicaDos = c2;
    }

    /*
     * @param competidorUno
     * @param competidorDos
     * @return un entero que se utiliza para ordenar descendentemente.
     */
    @Override
    public int compare(Competidor competidorUno, Competidor competidorDos) {

        if (Double.compare(competidorUno.getCaracteristica(caracteristicaUno), competidorDos.getCaracteristica(caracteristicaUno)) == 0) {
            return -Double.compare(competidorUno.getCaracteristica(caracteristicaDos), competidorDos.getCaracteristica(caracteristicaDos));
        }
        return -Double.compare(competidorUno.getCaracteristica(caracteristicaUno), competidorDos.getCaracteristica(caracteristicaUno));
    }

}