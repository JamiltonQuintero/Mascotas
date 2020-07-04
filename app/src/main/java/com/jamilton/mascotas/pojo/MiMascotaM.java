package com.jamilton.mascotas.pojo;

public class MiMascotaM {

    private int imagen, imagenHue,numLikes;



    public MiMascotaM(int numLikes, int imagen, int imagenHue) {
        this.numLikes = numLikes;
        this.imagen = imagen;
        this.imagenHue = imagenHue;
    }

    public int tNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
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

