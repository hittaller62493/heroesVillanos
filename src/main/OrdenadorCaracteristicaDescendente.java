package main;

import java.util.Comparator;

import clases.Caracteristica;
import clases.Competidor;

public class OrdenadorCaracteristicaDescendente implements Comparator<Competidor> {

    private Caracteristica caracteristicaUno;
    private Caracteristica caracteristicaDos;

    public OrdenadorCaracteristicaDescendente(Caracteristica c1, Caracteristica c2) {
        this.caracteristicaUno = c1;
        this.caracteristicaDos = c2;
    }

    @Override
    public int compare(Competidor competidorUno, Competidor competidorDos) {

        if (Double.compare(competidorUno.getCaracteristica(caracteristicaUno), competidorDos.getCaracteristica(caracteristicaUno)) == 0) {
            return -Double.compare(competidorUno.getCaracteristica(caracteristicaDos), competidorDos.getCaracteristica(caracteristicaDos));
        }
        return -Double.compare(competidorUno.getCaracteristica(caracteristicaUno), competidorDos.getCaracteristica(caracteristicaUno));
    }

}