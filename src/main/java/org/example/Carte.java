package org.example;

public class Carte extends Publicatie {
    private Integer numarPagini;


    public Carte(String titlu, String autor, int anPublicare, int numarPagini) {
        super(titlu, autor, anPublicare);
        this.numarPagini = numarPagini;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "numarPagini" + numarPagini +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", anPublicare=" + anPublicare +
                '}';
    }

    public int getNumarPagini() {
        return numarPagini;
    }

    public void setNumarPagini(int nrExemplare) {
        this.numarPagini = nrExemplare;
    }


    public int getNrCuvinte(){
        return numarPagini * 1200;
    }
}
