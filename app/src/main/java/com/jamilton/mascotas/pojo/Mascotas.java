package com.jamilton.mascotas.pojo;

public class Mascotas {
    private String nMascota;
    private String numLikes;
    private int imagen, imagenHue;



    public Mascotas(String nMascota, String numLikes, int imagen, int imagenHue) {
        this.nMascota = nMascota;
        this.numLikes = numLikes;
        this.imagen = imagen;
        this.imagenHue = imagenHue;
    }
    public String getnMascota() {
        return nMascota;
    }

    public void setnMascota(String nMascota) {
        this.nMascota = nMascota;
    }

    public String getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(String numLikes) {
        this.numLikes = numLikes;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getImagenHue() {
        return imagenHue;
    }

    public void setImagenHue(int imagenHue) {
        this.imagenHue = imagenHue;
    }
}
