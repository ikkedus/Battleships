package com.company;

/**
 * Created by martin on 3/2/2017.
 */
public class CelPosition {

    public int rij;
    public int kolum;

    public CelPosition(int rij, int kolum) {
        this.rij = rij;
        this.kolum = kolum;
    }

    public int getRij() {
        return rij;
    }

    public void setRij(int rij) {
        this.rij = rij;
    }


    public int getKolum() {
        return kolum;
    }

    public void setKolum(int kolum) {
        this.kolum = kolum;
    }
}
