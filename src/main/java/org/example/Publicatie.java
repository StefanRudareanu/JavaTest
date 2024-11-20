package org.example;

public class Publicatie {
    protected String titlu;
    protected String autor;
    protected Integer anPublicare;

    public Publicatie(String titlu, String autor, int anPublicare) {
        this.titlu = titlu;
        this.autor = autor;
        this.anPublicare = anPublicare;
    }


    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnPublicare() {
        return anPublicare;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnPublicare(int anPublicare) {
        this.anPublicare = anPublicare;
    }
}
